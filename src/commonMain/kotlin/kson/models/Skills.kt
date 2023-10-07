package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Skills(
    override val index: String,
    override val name: String,
    override val url: String,
    val desc: List<String>,
    @SerialName("ability_score")
    val abilityScore: APIReference
) : IRef
