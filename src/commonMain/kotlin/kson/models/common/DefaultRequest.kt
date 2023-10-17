package kson.models.common

import kotlinx.serialization.Serializable

@Serializable
data class DefaultRequest(
    val count: Int,
    val results: List<APIReference>
)