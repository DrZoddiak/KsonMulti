package kson.models

import kotlinx.serialization.Serializable

@Serializable
data class Proficiencies(
    val index: String,
    val type: String,
    val name: String,
    val classes: List<APIReference>,
    val races: List<APIReference>,
    val url: String,
    val reference: References
)

@Serializable
data class References(
    val name: String,
    val index: String,
    val type: String? = null,
    val url: String
)