package kson.models

import kotlinx.serialization.Serializable

@Serializable
data class DefaultRequest(
    val count: Int,
    val results: List<APIReference>
)

@Serializable
data class APIReference(
    override val index: String,
    override val name: String,
    override val url: String
) : IRef

@Serializable
data class Cost(
    val quantity: Int,
    val unit: String
)