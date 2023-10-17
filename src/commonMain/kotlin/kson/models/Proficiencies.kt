package kson.models

import kotlinx.serialization.Serializable
import kson.models.common.APIReference
import kson.models.common.IRef

@Serializable
data class Proficiencies(
    override val index: String,
    override val name: String,
    override val url: String,
    val type: String,
    val classes: List<APIReference>,
    val races: List<APIReference>,
    val reference: References
) : IRef

@Serializable
data class References(
    override val name: String,
    override val index: String,
    override val url: String,
    val type: String? = null
) : IRef