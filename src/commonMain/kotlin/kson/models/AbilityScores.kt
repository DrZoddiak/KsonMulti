package kson.models

import kotlinx.serialization.Serializable

@Serializable
data class AbilityScores(
    override var index: String,
    override var name: String,
    var full_name: String,
    var desc: List<String>,
    var skills: List<APIReference>,
    override var url: String
) : DefaultTrait



