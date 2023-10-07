package kson.models

import kotlinx.serialization.Serializable

@Serializable
data class EquipmentCategories(
    override val index: String,
    override val name: String,
    override val url: String,
    val equipment: List<APIReference>
) : IRef