package kson.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Languages(
    override val index: String,
    override val name: String,
    val desc : String? = null,
    val type: String,
    val typical_speakers: List<String>,
    val script: String? = null,
    override val url: String
) : DefaultTrait {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}