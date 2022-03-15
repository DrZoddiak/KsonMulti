package kson

import io.ktor.client.*
import io.ktor.client.request.*
import kson.models.DefaultRequest
import kson.models.Indexable
import kson.models.Nameable
import kotlin.reflect.KClass

class KsonApi(val client: HttpClient, val apiUrl: String = "https://www.dnd5eapi.co/api") {

    suspend inline fun <reified T> fetch(input: String): T {
        val name = T::class.friendlyName()
        return client.get("$apiUrl/$name/${input.lowercase()}")
    }

    suspend inline fun <reified T> query(input: String): DefaultRequest {
        val name = T::class.friendlyName()
        return client.get("$apiUrl/$name?${input.lowercase()}")
    }
}

fun KClass<*>.friendlyName(): String? = simpleName?.replace(Regex("(?<=.)([A-Z])"), "-$1")

//Extension Functions
fun List<Nameable>.names() = this.joinToString(", ") { it.name }

//This is mostly for testing, but leaving open for other uses.
fun List<Indexable>.indexes() = this.joinToString("\",\n\"", "\"", "\"") { it.index }

//These are for Queryable
fun Array<out String>.sortContent(prefix: String) = "$prefix=${this.joinToString(",")}"
fun IntArray.sortContent(prefix: String) = "$prefix=${this.joinToString(",")}"
fun DoubleArray.sortContent(prefix: String) = "$prefix=${this.joinToString(",")}"

