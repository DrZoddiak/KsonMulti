package kson.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Alignments(
    override val index: String,
    override val name: String,
    override val url: String,
    val desc: String,
    val abbreviation: String
) : IRef
