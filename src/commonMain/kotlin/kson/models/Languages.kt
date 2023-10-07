package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Languages(
    override val index: String,
    override val name: String,
    override val url: String,
    val desc: String? = null,
    val type: String, //todo: enum
    val script: String? = null,
    @SerialName("typical_speakers")
    val typicalSpeakers: List<String>
) : IRef