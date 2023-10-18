package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kson.models.common.Queryable
import kson.models.common.IRef

@Serializable
data class Languages(
    override val index: String,
    override val name: String,
    override val url: String,
    val desc: String? = null,
    val type: String, //todo: enum
    val script: String? = null,
    @SerialName("typical_speakers")
    val typicalSpeakers: List<String>,
) : IRef {
    companion object : Queryable
}