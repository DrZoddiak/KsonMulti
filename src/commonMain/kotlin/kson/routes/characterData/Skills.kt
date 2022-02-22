package kson.routes.characterData

import kotlinx.serialization.Serializable
import kson.routes.APIReference
import kson.routes.DefaultTrait

@Serializable
data class Skills(
    override val index: String?,
    override val name: String?,
    val desc: List<String?>?,
    val ability_score: List<APIReference?>?,
    override val url: String?
) : DefaultTrait
