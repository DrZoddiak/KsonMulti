package kson.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class MagicItems(
    val index: String,
    val name: String,
    val equipmentCategory: APIReference,
    val desc: List<String>
) {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}