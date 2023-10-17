package kson.models.common

import kotlinx.serialization.Serializable

@Serializable
data class Cost(
    val quantity: Int,
    val unit: String
)