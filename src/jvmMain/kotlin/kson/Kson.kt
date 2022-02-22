package kson

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kson.routes.Monsters
import kson.routes.characterData.AbilityScores

private val client = HttpClient(CIO) {
    install(JsonFeature) {
        val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
        serializer = KotlinxSerializer(json)
    }
    engine {
        // this: CIOEngineConfig
        maxConnectionsCount = 1000
        endpoint {
            // this: EndpointConfig
            maxConnectionsPerRoute = 100
            pipelineMaxSize = 20
            keepAliveTime = 5000
            connectTimeout = 5000
            connectAttempts = 5
        }
    }
}

const val apiUrl = "https://www.dnd5eapi.co/api"

interface Fetchable {
    suspend fun fetch(input: String): Any {
        return client.get("$apiUrl//$input")
    }
}


object Monsters : Fetchable {
    override suspend fun fetch(input: String): Monsters {
        return client.get("$apiUrl/monsters/$input")
    }
}

object CharacterData {
    object AbilityScores : Fetchable {
        override suspend fun fetch(input: String): kson.routes.characterData.AbilityScores {
            return client.get("$apiUrl/ability-scores/$input")
        }
    }

    object Alignments : Fetchable {
        override suspend fun fetch(input: String): kson.routes.characterData.Alignments {
            return client.get("$apiUrl/alignments/$input")
        }
    }

    object Languages : Fetchable {
        override suspend fun fetch(input: String): Languages {
            return client.get("$apiUrl/languages/$input")
        }
    }

    object Proficiencies : Fetchable {
        override suspend fun fetch(input: String): Proficiencies {
            return client.get("$apiUrl/proficiencies/$input")
        }
    }

    object Skills : Fetchable {
        override suspend fun fetch(input: String): Skills {
            return client.get("$apiUrl/skills/$input")
        }
    }
}
