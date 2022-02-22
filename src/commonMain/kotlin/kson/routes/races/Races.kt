package kson.routes.races

import kotlinx.serialization.Serializable
import kson.routes.APIReference
import kson.routes.Choice

@Serializable
data class Races(
    val index: String?,
    val name: String?,
    val speed: Int?,
    val ability_bonuses: List<AbilityBonuses?>?,
    val alignment: String?,
    val age: String?,
    val size: String?,
    val size_description: String?,
    val starting_proficiencies: List<APIReference?>?,
    val starting_proficiency_options : Choice?,
    val languages: List<APIReference?>?,
    val language_desc: String?,
    val traits: List<APIReference?>?,
    val subraces: List<APIReference?>?,
    val url: String?
)

@Serializable
data class AbilityBonuses(
    val ability_score: List<APIReference?>?,
    val bonus: Int?
)