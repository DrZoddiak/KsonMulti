package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Subclasses(
    val index: String,
    val name: String,
    val url: String,
    val desc: List<String>,
    @SerialName("class")
    val clazz: APIReference,
    val subclass_flavor: String,
    val subclass_levels: String,
    val spells: List<Spell>

)

@Serializable
data class Spell(
    val prerequisites: List<SpellPrerequisites>,
    val spell: APIReference
)

@Serializable
data class SpellPrerequisites(
    val index: String,
    val name: String,
    val type: String,
    val url: String
)