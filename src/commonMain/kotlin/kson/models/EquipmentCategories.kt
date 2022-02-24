package kson.models

import kotlinx.serialization.Serializable
import kson.APIReference
import kson.DefaultTrait

@Serializable
data class EquipmentCategories(
    override val index: String,
    override val name: String,
    val equipment: List<APIReference>,
    override val url: String
) : DefaultTrait