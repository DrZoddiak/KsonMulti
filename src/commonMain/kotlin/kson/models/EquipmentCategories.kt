package kson.models

import kotlinx.serialization.Serializable

@Serializable
data class EquipmentCategories(
    val index: String,
    val name: String,
    val equipment: List<APIReference>,
    val url: String
)