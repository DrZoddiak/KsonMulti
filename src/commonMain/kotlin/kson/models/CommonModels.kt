package kson.models

import kotlinx.serialization.Serializable

@Serializable
data class DefaultRequest(
    val count: Int,
    val results: List<APIReference>
)

@Serializable
data class APIReference(
    val index: String,
    val name: String,
    val url: String
)

@Serializable
data class Cost(
    val quantity: Int,
    val unit: String
)