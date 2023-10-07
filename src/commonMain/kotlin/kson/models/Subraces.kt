package kson.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject

@Serializable
data class Subraces(
    val index: String,
    val name: String,
    val url: String,
    val desc: String,
    val race: APIReference,
    val ability_bonuses: List<AbilityBonus>,
    val starting_proficiencies: List<APIReference>,
    val languages : JsonArray,
    val language_options: JsonObject? = null,
    val racial_traits: List<APIReference>
)

@Serializable
data class AbilityBonus(
    val ability_score: APIReference,
    val bonus: Int,
)
