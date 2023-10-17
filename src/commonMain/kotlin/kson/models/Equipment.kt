package kson.models

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject

@Serializable
data class Equipment(
    override val index: String,
    override val name: String,
    override val url: String,
    @SerialName("armor_category")
    val armorCategory: String? = null,
    @SerialName("armor_class")
    val armorClass: ArmorClass? = null,
    val capacity: String? = null,
    @SerialName("category_range")
    val categoryRange: String? = null,
    val contents: List<Content>? = null,
    val desc: List<String>,
    @SerialName("gear_category")
    val gearCategory: APIReference? = null,
    @SerialName("equipment_category")
    val equipmentCategory: APIReference,
    @SerialName("weapon_category")
    val weaponCategory: String? = null,
    @SerialName("weapon_range")
    val weaponRange: String? = null,
    val cost: Cost,
    val damage: Damage? = null,
    @SerialName("two_handed_damage")
    val twoHandedDamage: Damage? = null,
    val range: Range? = null,
    val weight: Double? = null,
    val properties: List<APIReference>? = null,
    val quantity: Int? = null,
    val special: List<String>? = null,
    val speed: Speed? = null,
    @SerialName("stealth_disadvantage")
    val stealthDisadvantage: Boolean? = null,
    @SerialName("str_minimum")
    val strMinimum: Int? = null,
    @SerialName("throw_range")
    val throwRange: ThrowRange? = null,
    @SerialName("tool_category")
    val toolCategory: String? = null,
    @SerialName("vehicle_category")
    val vehicleCategory: String? = null
) : IRef

@Serializable
data class ArmorClass(
    val base: Int,
    @SerialName("dex_bonus")
    val dexBonus: Boolean,
    @SerialName("max_bonus")
    val maxBonus: Int? = null
)

@Serializable
data class Content(
    val item: APIReference,
    val quantity: Int
)

@Serializable
data class ThrowRange(
    val long: Int,
    val normal: Int
)


@Serializable
data class Range(
    val long: Int? = null,
    val normal: Int
)