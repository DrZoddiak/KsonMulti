package kson.routes.equipment

import kotlinx.serialization.Serializable
import kson.routes.APIReference
import kson.routes.DefaultTrait

@Serializable
data class EquipmentCategories(
    val index: String?,
    val name: String?,
    val equipment: List<APIReference>?,
)