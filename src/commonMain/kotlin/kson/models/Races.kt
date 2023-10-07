package kson.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject

@Serializable
data class Races(
    val index: String,
    val name: String,
    val speed: Int,
    val ability_bonuses: List<AbilityBonuses>,
    val ability_bonus_options: JsonObject? = null,
    val alignment: String,
    val age: String,
    val size: String,
    val size_description: String,
    val starting_proficiencies: List<APIReference>,
    val starting_proficiency_options: JsonObject? = null,
    val languages: List<APIReference>,
    val language_desc: String,
    val traits: List<APIReference>,
    val subraces: List<APIReference>,
    val url: String
)

@Serializable
data class AbilityBonuses(
    val ability_score: APIReference,
    val bonus: Int
) {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

@Serializable
data class AbilityBonusOptions(
    val choose: Int,
    val from: List<AbilityBonuses>,
    val type: String
)

@Serializable
data class StartingProficiencyOptions(
    val choose: Int,
    val from: List<APIReference>,
    val type: String
)