package kson.models

import kotlinx.serialization.Serializable

@Serializable
data class Rules(
    val index: String,
    val name: String,
    val desc: String,
    val subsections: List<APIReference>,
    val url: String
)