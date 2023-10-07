package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MagicItems(
    override val index: String,
    override val name: String,
    override val url: String,
    @SerialName("equipment_category")
    val equipmentCategory: APIReference? = null,
    val desc: List<String>
): IRef