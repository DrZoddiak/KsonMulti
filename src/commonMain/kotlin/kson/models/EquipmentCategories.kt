package kson.models

import kotlinx.serialization.Serializable
import kson.models.common.Queryable
import kson.models.common.APIReference
import kson.models.common.IRef

@Serializable
data class EquipmentCategories(
    override val index: String,
    override val name: String,
    override val url: String,
    val equipment: List<APIReference>
) : IRef {
    companion object : Queryable
}