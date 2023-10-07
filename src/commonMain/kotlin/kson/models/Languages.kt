package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Languages(
    val index: String,
    val name: String,
    val url: String,
    val desc: String,
    val type: String, //todo: enum
    val script: String,
    @SerialName("typical_speakers")
    val typicalSpeakers: List<String>
)