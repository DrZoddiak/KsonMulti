package kson.routes.equipment

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import kson.routes.APIReference
import kson.routes.DefaultTrait

@Serializable
data class Equipment(
    val index: String?,
    val name: String?,
    val equipmentCategory: List<APIReference>?,
    val gear_category: List<APIReference>?,
    val cost: List<Cost>?,
    val damage: JsonObject?,
    val two_handed_damage: JsonObject?,
    val range: JsonObject?,
    val weight: Int?,
    val properties: List<APIReference?>?,
    val url: String?
)

@Serializable
data class Cost(
    val quantity: Int?,
    val unit: String?
)