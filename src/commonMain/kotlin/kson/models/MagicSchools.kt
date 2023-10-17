package kson.models

import kotlinx.serialization.Serializable
import kson.models.common.IRef

@Serializable
data class MagicSchools(
    override val index: String,
    override val name: String,
    override val url: String,
    val desc: String
) : IRef