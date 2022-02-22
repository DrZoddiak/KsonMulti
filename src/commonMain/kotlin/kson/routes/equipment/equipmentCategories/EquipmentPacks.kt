package kson.routes.equipment.equipmentCategories

import kotlinx.serialization.Serializable
import kson.routes.APIReference
import kson.routes.Cost
import kson.routes.DefaultTrait

@Serializable
data class EquipmentPacks(
    override val index: String?,
    override val name: String?,
    val equipment_category: APIReference?,
    val gear_category: APIReference?,
    val cost: Cost?,
    val contents: List<APIReference>?,
    override val url: String?
) : DefaultTrait