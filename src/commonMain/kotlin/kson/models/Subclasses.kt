package kson.models

import kotlinx.serialization.Serializable
import kson.APIReference

@Serializable
data class Subclasses(
    val count: Int,
    val results: List<APIReference>
)