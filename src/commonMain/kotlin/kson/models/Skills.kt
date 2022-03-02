package kson.models

import kotlinx.serialization.Serializable

@Serializable
data class Skills(
    override val index: String,
    override val name: String,
    val desc: List<String>,
    val ability_score: List<APIReference>,
    override val url: String
) : DefaultTrait
