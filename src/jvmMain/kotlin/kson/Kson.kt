package kson

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

val client = HttpClient(CIO) {
    install(JsonFeature) {
        val json = kotlinx.serialization.json.Json {
            ignoreUnknownKeys = true
            prettyPrint = true
            isLenient = true
        }
        serializer = KotlinxSerializer(json)
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




