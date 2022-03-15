package kson.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Feats(
    override val index: String,
    override val name: String,
    val prerequisites: List<Prerequisite>,
    val desc: List<String>,
    override val url: String
) : DefaultTrait {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

@Serializable
data class Prerequisite(
    val ability_score: APIReference,
    val minimum_score: Int
)
