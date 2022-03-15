package kson.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Equipment(
    override val index: String,
    override val name: String,
    val armor_category: String? = null,
    val armor_class: ArmorClass? = null,
    val capacity: String? = null,
    val category_range: String? = null,
    val contents: List<Content>? = null,
    val desc: List<String>,
    val gear_category: APIReference? = null,
    val equipment_category: APIReference,
    val weapon_category: String? = null,
    val weapon_range: String? = null,
    val cost: Cost,
    val damage: Damage? = null,
    val two_handed_damage: Damage? = null,
    val range: Range? = null,
    val weight: Double? = null,
    val properties: List<APIReference>? = null,
    val quantity: Int? = null,
    val special: List<String>? = null,
    val speed: Speed? = null,
    val stealth_disadvantage: Boolean? = null,
    val str_minimum: Int? = null,
    val throw_range: ThrowRange? = null,
    val tool_category: String? = null,
    val vehicle_category: String? = null,
    override val url: String
) : DefaultTrait {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

@Serializable
data class ArmorClass(
    val base: Int,
    val dex_bonus: Boolean,
    val max_bonus: Int? = null
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

@Serializable
data class Damage(
    val damage_dice: String,
    val damage_type: APIReference
)
