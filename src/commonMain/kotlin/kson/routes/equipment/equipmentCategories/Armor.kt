package kson.routes.equipment.equipmentCategories

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import kson.routes.APIReference
import kson.routes.Cost
import kson.routes.DefaultTrait

@Serializable
data class Armor(
    override val index: String?,
    override val name: String?,
    val equipmentCategory: APIReference?,
    val armor_category: String?,
    val armor_class: JsonObject?,
    val str_minimum: Int?,
    val stealth_disadvantage: Boolean?,
    val weight: Int?,
    val cost: Cost?,
    override val url: String?
) : DefaultTrait
