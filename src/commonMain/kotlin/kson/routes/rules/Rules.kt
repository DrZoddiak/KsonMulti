package kson.routes.rules

import kotlinx.serialization.Serializable
import kson.routes.APIReference
import kson.routes.DefaultTrait

@Serializable
data class Rules(
    override val index: String?,
    override val name: String?,
    val desc: String?,
    val subsections: List<APIReference>?,
    override val url: String?
) : DefaultTrait
