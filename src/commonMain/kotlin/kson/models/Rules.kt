package kson.models

import kotlinx.serialization.Serializable
import kson.models.common.APIReference
import kson.models.common.IRef

@Serializable
data class Rules(
    override val index: String,
    override val name: String,
    override val url: String,
    val desc: String,
    val subsections: List<APIReference>
) : IRef