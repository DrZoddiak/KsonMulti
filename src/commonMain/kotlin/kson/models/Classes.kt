package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kson.models.common.Queryable
import kson.models.common.APIReference
import kson.models.common.Choice
import kson.models.common.IRef

@Serializable
data class Classes(
    override val index: String,
    override val name: String,
    override val url: String,
    @SerialName("hit_die")
    val hitDie: Int,
    @SerialName("class_levels")
    val classLevels: String,
    @SerialName("multi_classing")
    val multiClassing: MultiClassing,
    val spellcasting: Spellcasting? = null,
    val spells: String? = null,
    @SerialName("starting_equipment")
    val startingEquipment: List<StartingEquipment>,
    @SerialName("starting_equipment_options")
    val startingEquipmentOptions: List<Choice>,
    @SerialName("proficiency_choices")
    val proficiencyChoices: List<Choice>,
    val proficiencies: List<APIReference>,
    @SerialName("saving_throws")
    val savingThrows: List<APIReference>,
    val subclasses: List<APIReference>,
) : IRef {
    companion object : Queryable
}

@Serializable
data class Spellcasting(
    val level: Int,
    val info: List<Info>,
    @SerialName("spellcasting_ability")
    val spellcastingAbility: APIReference
)

@Serializable
data class Info(
    val name: String,
    val desc: List<String>
)

@Serializable
data class MultiClassing(
    val prerequisites: List<MultiClassingPreReq>? = null,
    @SerialName("prerequisite_options")
    val prerequisiteOptions: Choice? = null,
    val proficiencies: List<APIReference>,
    @SerialName("proficiency_choices")
    val proficiencyChoices: List<Choice>? = null
)

@Serializable
data class MultiClassingPreReq(
    @SerialName("ability_score")
    val abilityScore: APIReference,
    @SerialName("minimum_score")
    val minimumScore: Int
)
