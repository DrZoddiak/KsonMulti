package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Subclasses(
    override val index: String,
    override val name: String,
    @SerialName("class")
    val clazz: APIReference,
    val spells: List<Spell>,
    val subclass_flavor: String,
    val subclass_levels: String,
    val desc: List<String>,
    override val url: String

) : DefaultTrait {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

@Serializable
data class Spell(
    val prerequisites: List<SpellPrerequisites>,
    val spell: APIReference
)

@Serializable
data class SpellPrerequisites(
    override val index: String,
    override val name: String,
    val type: String,
    override val url: String
) : DefaultTrait