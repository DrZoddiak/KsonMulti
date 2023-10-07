package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AbilityScores(
    val index: String,
    val name: String,
    val url: String,
    val desc: List<String>,
    @SerialName("full_name")
    val fullName: String,
    val skills: List<APIReference>
)
