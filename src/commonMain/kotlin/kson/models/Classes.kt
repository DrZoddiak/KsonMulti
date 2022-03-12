package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject

@Serializable
@SerialName("Class")
data class Classes(
    override val index: String,
    override val name: String,
    val hit_die: Int,
    val proficiency_choices: List<ProficiencyChoice>,
    val proficiencies: List<APIReference>,
    val saving_throws: List<APIReference>,
    val starting_equipment: List<EquipmentContent>,
    val class_levels: String,
    val multi_classing: MultiClassing,
    val subclasses: List<APIReference>,
    val spellcasting: Spellcasting,
    val spells: String? = null,
    override val url: String
) : DefaultTrait {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

@Serializable
data class MultiClassing(
    val prerequisites: List<MultiClassingPreReq>,
    val prerequisite_options: MultiClassingPreReqOptions,
    val proficiencies: List<APIReference>,
    val proficiency_choices: List<ProficiencyChoice>
)

@Serializable
data class MultiClassingPreReqOptions(
    val choose: Int? = null,
    val from: List<MultiClassingPreReq>,
    val type: String? = null
)

@Serializable
data class MultiClassingPreReq(
    val ability_score: APIReference,
    val minimum_score: Int
)

@Serializable
data class ProficiencyChoice(
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
    val level: Int? = null,
    val spellcasting_ability: APIReference? = null,
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