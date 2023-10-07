package kson.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Alignments(
    val index: String,
    val name: String,
    val url: String,
    val desc: String,
    val abbreviation: String
)
