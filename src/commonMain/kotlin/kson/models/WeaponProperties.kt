package kson.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class WeaponProperties(
    val index: String,
    val name: String,
    val desc: List<String>,
    val url: String
)