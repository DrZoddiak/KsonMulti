package kson.models

import kotlinx.serialization.Serializable
import kson.models.common.IRef

@Serializable
data class Alignments(
    override val index: String,
    override val name: String,
    override val url: String,
    val desc: String,
    val abbreviation: String
) : IRef
