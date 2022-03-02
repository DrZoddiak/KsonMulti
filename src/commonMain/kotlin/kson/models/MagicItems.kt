package kson.models

import kotlinx.serialization.Serializable

@Serializable
data class MagicItems(
    val index: String,
    val name: String,
    val equipmentCategory: APIReference,
    val desc: List<String>
)