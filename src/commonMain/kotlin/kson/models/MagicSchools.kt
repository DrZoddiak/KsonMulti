package kson.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class MagicSchools(
    override val index: String,
    override val name: String,
    override val url: String,
    val desc: String
) : IRef