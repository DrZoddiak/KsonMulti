package kson

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

val client = HttpClient(CIO) {
    install(ContentNegotiation) {
        json(Json {
            //type keyword is used in DND API
            classDiscriminator = "#class"
            //todo: remove for production
            //ignoreUnknownKeys = true
            //prettyPrint = true
            //isLenient = true
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