package kson.models

import kotlinx.serialization.Serializable

@Serializable
data class Rules(
    override val index: String,
    override val name: String,
    val desc: String,
    val subsections: List<APIReference>,
    override val url: String
) : DefaultTrait
