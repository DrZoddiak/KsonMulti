package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kson.models.common.APIReference
import kson.models.common.IRef

@Serializable
data class Spells(
    override val index: String,
    override val name: String,
    override val url: String,
    val desc: List<String>,
    @SerialName("higher_level")
    val higherLevel: List<String>? = null,
    val range: String,
    val components: List<String>,
    val material: String? = null,
    @SerialName("area_of_effect")
    val areaOfEffect: AreaOfEffect? = null,
    val ritual: Boolean,
    val duration: String,
    val concentration: Boolean,
    @SerialName("casting_time")
    val castingTime: String,
    val level: Int,
    @SerialName("attack_type")
    val attackType: String? = null,
    val damage: DamageContent? = null,
    val dc: SpellDC? = null,
    val school: APIReference,
    val classes: List<APIReference>,
    val subclasses: List<APIReference>,
    @SerialName("heal_at_slot_level")
    val healAtSlotLevel: SlotLevel? = null,
) : IRef

@Serializable
data class SpellDC(
    @SerialName("dc_type")
    val dcType: APIReference,
    @SerialName("dc_success")
    val dcSuccess: String,
    val desc: String? = null,
)

@Serializable
data class DamageContent(
    @SerialName("damage_at_slot_level")
    val damageAtSlotLevel: SlotLevel? = null,
    @SerialName("damage_at_character_level")
    val damageAtCharacterLevel: SlotLevel? = null,
    @SerialName("damage_type")
    val damageType: APIReference? = null
)

@Serializable
data class SlotLevel(
    //Name is numerical, but kotlin doesn't support numerical names.
    @SerialName("1")
    val one: String? = null,
    @SerialName("2")
    val two: String? = null,
    @SerialName("3")
    val three: String? = null,
    @SerialName("4")
    val four: String? = null,
    @SerialName("5")
    val five: String? = null,
    @SerialName("6")
    val six: String? = null,
    @SerialName("7")
    val seven: String? = null,
    @SerialName("8")
    val eight: String? = null,
    @SerialName("9")
    val nine: String? = null,
    @SerialName("11")
    val eleven: String? = null,
    @SerialName("17")
    val seventeen: String? = null,
)

@Serializable
data class AreaOfEffect(
    val size: Int,
    val type: String
)


