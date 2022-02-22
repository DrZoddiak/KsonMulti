package kson.routes.classes

import kotlinx.serialization.Serializable
import kson.routes.APIReference
import kson.routes.DefaultTrait

@Serializable
data class Subclasses(
    val count: Int?,
    val results: List<APIReference?>?
)