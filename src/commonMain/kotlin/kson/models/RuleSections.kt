package kson.models

import kotlinx.serialization.Serializable
import kson.DefaultTrait

@Serializable
data class RuleSections(
    override val name: String,
    override val index: String,
    val desc: String,
    override val url: String
) : DefaultTrait