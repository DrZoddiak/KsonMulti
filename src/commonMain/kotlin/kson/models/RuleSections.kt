package kson.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class RuleSections(
    val name: String,
    val index: String,
    val desc: String,
    val url: String
)