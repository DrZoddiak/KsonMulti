package kson.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class MagicItems(
    override val index: String,
    override val name: String,
    val equipmentCategory: APIReference? = null,
    val desc: List<String>,
    override val url: String
) : DefaultTrait {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}