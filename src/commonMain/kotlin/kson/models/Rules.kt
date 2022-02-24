package kson.models

import kotlinx.serialization.Serializable
import kson.APIReference
import kson.DefaultTrait

@Serializable
data class Rules(
    override val index: String,
    override val name: String,
    val desc: String,
    val subsections: List<APIReference>,
    override val url: String
) : DefaultTrait
