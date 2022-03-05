package kson

import io.ktor.client.*
import io.ktor.client.request.*
import kson.models.DefaultRequest
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

fun KClass<*>.friendlyName(): String? {
    val subCategories = listOf("weapons", "armor", "gear", "EquipmentPack")
    val friendlyName = "equipment"

    val simpleName = this.simpleName
    if (subCategories.contains(simpleName?.lowercase())) {
        return friendlyName
    }
    return simpleName?.replace(Regex("(?<=.)([A-Z])"), "-$1")
}

//Extension Functions

fun List<Any>.names() = this.joinToString(", ") {
    it as Nameable
    it.name
}