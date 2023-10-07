package kson

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kson.models.APIReference
import kson.models.DefaultRequest
import kotlin.reflect.KClass

class KsonApi(val client: HttpClient, val apiUrl: String = "https://www.dnd5eapi.co/api") {

    suspend inline fun <reified T> fetch(input: String): T {
        val name = T::class.friendlyName()
        return client.get("$apiUrl/$name/${input.lowercase()}").body()
    }

    suspend inline fun <reified T> query(input: String = ""): DefaultRequest {
        val name = T::class.friendlyName()
        val link = "$apiUrl/$name?${input.lowercase()}"
        return client.get(link).body<DefaultRequest>()
    }
}

fun KClass<*>.friendlyName(): String? = simpleName?.replace(Regex("(?<=.)([A-Z])"), "-$1")?.lowercase()

//Extension Functions
fun List<APIReference>.names() = this.joinToString(", ") { it.name }

//This is mostly for testing, but leaving open for other uses.
fun List<APIReference>.indexes() = this.joinToString("\",\n\"", "\"", "\"") { it.index }

//These are for Queryable
