package kson.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class MagicSchools(
    val index: String,
    val name: String,
    val desc: String,
    val url: String
)