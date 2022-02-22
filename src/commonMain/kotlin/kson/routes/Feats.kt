package kson.routes

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class Feats(
    override val index: String?,
    override val name: String?,
    val prerequisites: List<JsonObject?>?,
    val desc: List<String?>?,
    override val url: String?
) : DefaultTrait
