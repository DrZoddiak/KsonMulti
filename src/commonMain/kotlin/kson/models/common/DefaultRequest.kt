package kson.models.common

import kotlinx.serialization.Serializable

/**
 * This represents a common request format for the API
 * [count] is the amount of items in [results]
 * [results] is a list of [APIReference]
 */
@Serializable
data class DefaultRequest(
    val count: Int,
    val results: List<APIReference>
)