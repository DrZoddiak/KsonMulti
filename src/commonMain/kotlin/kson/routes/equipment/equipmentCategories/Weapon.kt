package kson.routes.equipment.equipmentCategories

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import kson.routes.APIReference
import kson.routes.Cost
import kson.routes.DefaultTrait

@Serializable
data class Weapon(
    override val index: String?,
    override val name: String?,
    val equipment_category : APIReference?,
    val weapon_category : String?,
    val weapon_range : String?,
    val category_range : String?,
    val cost : Cost?,
    val damage : JsonObject?,
    val two_handed_damage : JsonObject?,
    val range : JsonObject?,
    val weight : Int?,
    val properties : List<APIReference?>?,
    override val url: String?
) : DefaultTrait
