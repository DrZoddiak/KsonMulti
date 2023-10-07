package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray

@Serializable
data class Classes(
    val index: String,
    val name: String,
    val url: String,
    @SerialName("hit_die")
    val hitDie: Int,
    @SerialName("class_levels")
    val classLevels: String,
    @SerialName("multi_classing")
    val multiClassing: MultiClassing,
    val spellcasting: Spellcasting? = null,
    val spells: String? = null,
    @SerialName("starting_equipment")
    val startingEquipment: List<EquipmentContent>,
    @SerialName("starting_equipment_options")
    val startingEquipmentOptions: JsonArray,//todo: fix this
    val proficiency_choices: List<Choice>,
    val proficiencies: List<APIReference>,
    val saving_throws: List<APIReference>,
    val subclasses: List<APIReference>,
)

@Serializable
data class MultiClassing(
    val prerequisites: List<MultiClassingPreReq>? = null,
    val prerequisite_options: MultiClassingPreReqOptions? = null,
    val proficiencies: List<APIReference>,
    val proficiency_choices: List<Choice>? = null
)

@Serializable
data class MultiClassingPreReqOptions(
    val choose: Int? = null,
    val from: OptionSet,
    val type: String? = null
)

@Serializable
data class MultiClassingPreReq(
    val ability_score: APIReference,
    val minimum_score: Int
)

@Serializable
data class Spellcasting(
    val level: Int,
    val info: List<Info>,
    val spellcasting_ability: APIReference
)

@Serializable
data class Info(
    val name: String,
    val desc: List<String>
)