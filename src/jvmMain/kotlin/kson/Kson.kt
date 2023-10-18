package kson

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonNamingStrategy

@OptIn(ExperimentalSerializationApi::class)
val client = HttpClient(CIO) {
    install(ContentNegotiation) {
        json(Json {
            //type keyword is used in DND API
            classDiscriminator = "#class"
            namingStrategy = JsonNamingStrategy.SnakeCase
            //ignoreUnknownKeys = true
            //prettyPrint = true
            //isLenient = true
        })
    }
    engine {
        maxConnectionsCount = 3000
        endpoint {
            maxConnectionsPerRoute = 100
            pipelineMaxSize = 50
            keepAliveTime = 10000
            connectTimeout = 10000
            connectAttempts = 5
        }
    }
}