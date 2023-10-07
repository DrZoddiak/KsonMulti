package kson

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import kson.models.Classes

val client = HttpClient(CIO) {
    install(ContentNegotiation) {
        json(Json {
            ignoreUnknownKeys = true
            prettyPrint = true
            isLenient = true
        })
    }
    engine {
        // this: CIOEngineConfig
        maxConnectionsCount = 3000
        endpoint {
            // this: EndpointConfig
            maxConnectionsPerRoute = 100
            pipelineMaxSize = 50
            keepAliveTime = 10000
            connectTimeout = 10000
            connectAttempts = 5
        }
    }
}

suspend fun main() {
    val api = KsonApi(client)
    val q = api.query<Classes>()
    println(q)
}