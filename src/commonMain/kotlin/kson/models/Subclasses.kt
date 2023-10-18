package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kson.models.common.Queryable
import kson.models.common.APIReference
import kson.models.common.IRef

@Serializable
data class Subclasses(
    override val index: String,
    override val name: String,
    override val url: String,
    val desc: List<String>,
    @SerialName("class")
    val clazz: APIReference,
    val subclassFlavor: String,
    val subclassLevels: String,
    val spells: List<Spell>
): IRef {
    companion object : Queryable
}

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