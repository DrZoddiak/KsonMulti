package kson

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kson.models.common.DefaultRequest
import kotlin.reflect.KClass

class KsonApi(val client: HttpClient, val apiUrl: String = "https://www.dnd5eapi.co/api") {

    /**
     * [T] is the Type the fetch will attempt to serialize to
     * [input] is the index of the resource
     */
    suspend inline fun <reified T> fetch(input: String): T {
        val name = T::class.friendlyName()
        return client.get("$apiUrl/$name/${input.lowercase()}").body()
    }

    /**
     * [T] is the type you wish to query against
     * [input] is an optional query key
     * Returns a [DefaultRequest]
     */
    suspend inline fun <reified T> query(input: String = ""): DefaultRequest {
        val name = T::class.friendlyName()
        val link = "$apiUrl/$name?${input.lowercase()}"
        return client.get(link).body<DefaultRequest>()
    }

    //This is a hacky way to perform lookups on Generics using the types name.
    fun KClass<*>.friendlyName(): String? = simpleName?.replace(Regex("(?<=.)([A-Z])"), "-$1")?.lowercase()
}