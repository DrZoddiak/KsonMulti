package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AbilityScores(
    override val index: String,
    override val name: String,
    override val url: String,
    val desc: List<String>? = null,
    @SerialName("full_name")
    val fullName: String,
    val skills: List<APIReference>
) : IRef
