package kson.routes.equipment

import kotlinx.serialization.Serializable
import kson.routes.APIReference
import kson.routes.DefaultTrait

@Serializable
data class MagicItems(
    val index: String?,
    val name: String?,
    val equipmentCategory: APIReference?,
    val desc: List<String?>?
)