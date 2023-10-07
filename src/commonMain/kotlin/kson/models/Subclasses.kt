package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Subclasses(
    override val index: String,
    override val name: String,
    override val url: String,
    val desc: List<String>,
    @SerialName("class")
    val clazz: APIReference,
    @SerialName("subclass_flavor")
    val subclassFavor: String,
    @SerialName("subclass_levels")
    val subclassLevels: String,
    val spells: List<Spell>
): IRef

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