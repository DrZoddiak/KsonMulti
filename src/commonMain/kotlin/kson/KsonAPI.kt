package kson

import io.ktor.client.*
import io.ktor.client.request.*
import kson.models.DefaultRequest
import kotlin.reflect.KClass

class KsonApi(val client: HttpClient, val apiUrl: String = "https://www.dnd5eapi.co/api") {

    private val subCategories = listOf("weapons", "armor", "gear", "EquipmentPack")
    private val friendlyName = "equipment"

    suspend inline fun <reified T> fetch(input: String): T {
        val name = T::class.friendlyName()
        return client.get("$apiUrl/$name/${input.lowercase()}")
    }

    suspend inline fun <reified T> query(input: String): DefaultRequest {
        val name = T::class.friendlyName()
        return client.get("$apiUrl/$name?${input.lowercase()}")
    }

    fun KClass<*>.friendlyName(): String? {
        val simpleName = this.simpleName
        if (subCategories.contains(simpleName?.lowercase())) {
            return friendlyName
        }
        return simpleName?.replace(Regex("(?<=.)([A-Z])"), "-$1")
    }
}