package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Feats(
    override val index: String,
    override val name: String,
    override val url: String,
    val prerequisites: List<Prerequisite>,
    val desc: List<String>
) : IRef

@Serializable
data class Prerequisite(
    @SerialName("ability_score")
    val abilityScore: APIReference,
    @SerialName("minimum_score")
    val minimumScore: Int
)
