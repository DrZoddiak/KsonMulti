package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MagicItems(
    override val index: String,
    override val name: String,
    override val url: String,
    val desc: List<String>,
    @SerialName("equipment_category")
    val equipmentCategory: APIReference? = null,
    val rarity: Rarity,
    val variants: List<APIReference>,
    val variant: Boolean
) : IRef

@Serializable
data class Rarity(
    val name: String,
)