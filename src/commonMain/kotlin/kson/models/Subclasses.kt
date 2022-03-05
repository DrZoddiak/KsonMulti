package kson.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Subclasses(
    val count: Int,
    val results: List<APIReference>
) {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}