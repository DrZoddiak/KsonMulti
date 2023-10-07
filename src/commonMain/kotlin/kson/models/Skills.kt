package kson.models

import kotlinx.serialization.Serializable

@Serializable
data class Skills(
    val index: String,
    val name: String,
    val desc: List<String>,
    val ability_score: APIReference,
    val url: String
)
