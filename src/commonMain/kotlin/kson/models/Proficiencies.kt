package kson.models

import kotlinx.serialization.Serializable
import kson.APIReference
import kson.DefaultTrait

@Serializable
data class Proficiencies(
    override val index: String,
    val type: String,
    override val name: String,
    val classes: List<APIReference>,
    val races: List<String>,
    override val url: String,
    val references: List<APIReference>
) : DefaultTrait

@Serializable
data class References(
    override val name: String,
    override val index: String,
    val type: String,
    override val url: String
) : DefaultTrait