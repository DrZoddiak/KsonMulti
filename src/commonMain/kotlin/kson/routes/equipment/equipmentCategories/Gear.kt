package kson.routes.equipment.equipmentCategories

import kotlinx.serialization.Serializable
import kson.routes.APIReference
import kson.routes.Cost
import kson.routes.DefaultTrait

@Serializable
data class Gear(
    override val index: String?,
    override val name: String?,
    val equipment_category: APIReference?,
    val gear_category: APIReference?,
    val cost: Cost?,
    val weight: Int?,
    override val url: String?
) : DefaultTrait
