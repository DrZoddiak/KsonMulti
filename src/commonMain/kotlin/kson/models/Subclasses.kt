package kson.models

import kotlinx.serialization.Serializable

@Serializable
data class Subclasses(
    val count: Int,
    val results: List<APIReference>
)