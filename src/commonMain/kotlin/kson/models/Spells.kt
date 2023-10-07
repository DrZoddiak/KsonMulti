package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Spells(
    val index: String,
    val name: String,
    val area_of_effect: AreaOfEffect? = null,
    val heal_at_slot_level: HealAtSlotLevel? = null,
    val dc: DC? = null,
    val desc: List<String>,
    val higher_level: List<String>? = null,
    val range: String,
    val components: List<String>,
    val material: String? = null,
    val ritual: Boolean,
    val duration: String,
    val concentration: Boolean,
    val casting_time: String,
    val level: Int,
    val attack_type: String? = null,
    val damage: DamageContent? = null,
    val school: APIReference,
    val classes: List<APIReference>,
    val subclasses: List<APIReference>,
    val url: String
)

@Serializable
data class DamageContent(
    val damage_at_slot_level: SlotDamage? = null,
    val damage_at_character_level: LevelDamage? = null,
    val damage_type: APIReference? = null
)

@Serializable
data class LevelDamage(
    //Name is numerical, but kotlin doesn't support numerical names.
    @SerialName("1")
    val one: String,
    @SerialName("5")
    val five: String,
    @SerialName("11")
    val eleven: String,
    @SerialName("17")
    val seventeen: String
)

@Serializable
data class SlotDamage(
    //Name is numerical, but kotlin doesn't support numerical names.
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
)


@Serializable
data class HealAtSlotLevel(
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
)

@Serializable
data class AreaOfEffect(
    val size: Int,
    val type: String
)


