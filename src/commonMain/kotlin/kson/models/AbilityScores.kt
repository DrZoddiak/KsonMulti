package kson.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class AbilityScores(
    override var index: String,
    override var name: String,
    var full_name: String,
    var desc: List<String>,
    var skills: List<APIReference>,
    override var url: String
) : DefaultTrait {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}



