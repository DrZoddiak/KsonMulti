package kson.routes.characterData

import kotlinx.serialization.Serializable
import kson.routes.DefaultTrait

@Serializable
data class Languages(
    override val index: String?,
    override val name: String?,
    val type: String?,
    val typical_speakers: List<String?>?,
    val script: String?,
    override val url: String?
) : DefaultTrait