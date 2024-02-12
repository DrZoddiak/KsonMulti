package kson.models

import kotlinx.serialization.Serializable
import kson.models.common.Queryable
import kson.models.common.APIReference
import kson.models.common.IRef

@Serializable
data class MagicItems(
    override val index: String,
    override val name: String,
    override val url: String,
    val desc: List<String>,
    val equipmentCategory: APIReference? = null,
    val rarity: Rarity,
    val variants: List<APIReference>,
    val variant: Boolean
) : IRef {
    companion object : Queryable
}

@Serializable
data class Rarity(
    val name: String,
)