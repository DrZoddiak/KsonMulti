package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kson.models.common.APIReference
import kson.models.common.IRef

@Serializable
data class AbilityScores(
    override val index: String,
    override val name: String,
    override val url: String,
    val desc: List<String>,
    @SerialName("full_name")
    val fullName: String,
    val skills: List<APIReference>
) : IRef
