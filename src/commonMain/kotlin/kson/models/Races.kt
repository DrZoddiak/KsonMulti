package kson.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Races(
    override val index: String,
    override val name: String,
    val speed: Int,
    val ability_bonuses: List<AbilityBonuses>,
    val alignment: String,
    val age: String,
    val size: String,
    val size_description: String,
    val starting_proficiencies: List<APIReference>,
    val starting_proficiency_options: Choice,
    val languages: List<APIReference>,
    val language_desc: String,
    val traits: List<APIReference>,
    val subraces: List<APIReference>,
    override val url: String
) : DefaultTrait {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

@Serializable
data class AbilityBonuses(
    val ability_score: List<APIReference>,
    val bonus: Int
) {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}