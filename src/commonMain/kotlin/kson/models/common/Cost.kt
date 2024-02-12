package kson.models.common

import kotlinx.serialization.Serializable

/**
 * This represents a common type of Cost
 * [quantity] is the amount of currency
 * [unit] is the unit of that currency
 */
@Serializable
data class Cost(
    val quantity: Int,
    val unit: String
)