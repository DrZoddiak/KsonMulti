package kson.routes.characterData

import kotlinx.serialization.Serializable
import kson.routes.APIReference
import kson.routes.DefaultTrait
import kson.routes.Fetchable

@Serializable
data class AbilityScores(
    override var index: String?,
    override var name: String?,
    var full_name: String?,
    var desc: List<String?>?,
    var skills: List<APIReference?>?,
    override var url: String?
) : DefaultTrait, Fetchable()



