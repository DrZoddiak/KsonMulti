package kson.models

import kotlinx.serialization.Serializable
import kson.models.common.IRef

@Serializable
data class RuleSections(
    override val name: String,
    override val index: String,
    override val url: String,
    val desc: String
) : IRef