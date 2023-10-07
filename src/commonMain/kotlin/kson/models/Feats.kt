package kson.models

import kotlinx.serialization.Serializable

@Serializable
data class Feats(
    val index: String,
    val name: String,
    val prerequisites: List<Prerequisite>,
    val desc: List<String>,
    val url: String
)

@Serializable
data class Prerequisite(
    val ability_score: APIReference,
    val minimum_score: Int
)
