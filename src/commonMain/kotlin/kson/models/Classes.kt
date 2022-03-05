package kson.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject

@Serializable
data class Classes(
    override val index: String,
    override val name: String,
    val hit_die: Int,
    val proficiency_choices: List<ProficiencyChoices>,
    val proficiencies: List<APIReference>,
    val saving_throws: List<APIReference>,
    val starting_equipment: JsonObject,
    val class_levels: String,
    val multi_classing: JsonObject,
    val subclasses: List<APIReference>,
    val spellcasting: Spellcasting,
    val spells: String,
    override val url: String
) : DefaultTrait {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

@Serializable
data class ProficiencyChoices(
    val choose: Int,
    val type: String,
    val from: List<APIReference>
) {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

@Serializable
data class Spellcasting(
    val level: Int,
    val spellcasting_ability: APIReference,
    val info: List<Info>
) {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

@Serializable
data class Info(
    val desc: List<String>,
    val name: String
) {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}