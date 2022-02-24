package kson.models

import kotlinx.serialization.Serializable
import kson.DefaultTrait

@Serializable
data class Languages(
    override val index: String,
    override val name: String,
    val type: String,
    val typical_speakers: List<String>,
    val script: String,
    override val url: String
) : DefaultTrait