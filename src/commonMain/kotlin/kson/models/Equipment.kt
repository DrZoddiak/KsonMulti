package kson.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject


object Equipment {
    @Serializable
    data class Weapons(
        override val index: String,
        override val name: String,
        val equipment_category: APIReference,
        val weapon_category: String,
        val weapon_range: String,
        val cost: Cost,
        val damage: JsonObject,
        val two_handed_damage: JsonObject? = null,
        val range: JsonObject,
        val weight: Int,
        val properties: List<JsonObject>,
        override val url: String
    ) : DefaultTrait

    @Serializable
    data class Armor(
        override val index: String,
        override val name: String,
        val equipment_category: APIReference,
        val gear_category: String,
        val cost: Cost,
        val weight: Int,
        override val url: String
    ) : DefaultTrait

    @Serializable
    data class EquipmentPack(
        override val index: String,
        override val name: String,
        val equipment_category: APIReference,
        val gear_category: String,
        val cost: Cost,
        val contents: List<APIReference>,
        override val url: String
    ) : DefaultTrait

    @Serializable
    data class Gear(
        override val index: String,
        override val name: String,
        val equipment_category: APIReference,
        val gear_category: String,
        val cost: Cost,
        val weight: Int,
        override val url: String
    ) : DefaultTrait
}