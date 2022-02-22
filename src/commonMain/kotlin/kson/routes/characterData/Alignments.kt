package kson.routes.characterData

import kotlinx.serialization.Serializable
import kson.routes.DefaultTrait

@Serializable
data class Alignments(
    override val index: String?,
    override val name: String?,
    val abbreviation: String?,
    val desc: List<String?>?,
    override val url: String?
) : DefaultTrait
