package kson.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Rules(
    override val index: String,
    override val name: String,
    val desc: String,
    val subsections: List<APIReference>,
    override val url: String
) : DefaultTrait {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}
