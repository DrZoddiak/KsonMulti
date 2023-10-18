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
    val hitDie: Int,
    val classLevels: String,
    val multiClassing: MultiClassing,
    val spellcasting: Spellcasting? = null,
    val spells: String? = null,
    val startingEquipment: List<StartingEquipment>,
    val startingEquipmentOptions: List<Choice>,
    val proficiencyChoices: List<Choice>,
    val proficiencies: List<APIReference>,
    val savingThrows: List<APIReference>,
    val subclasses: List<APIReference>,
) : IRef {
    companion object : Queryable
}

@Serializable
data class Spellcasting(
    val level: Int,
    val info: List<Info>,
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
    val prerequisiteOptions: Choice? = null,
    val proficiencies: List<APIReference>,
    val proficiencyChoices: List<Choice>? = null
)

@Serializable
data class MultiClassingPreReq(
    val abilityScore: APIReference,
    val minimumScore: Int
)
