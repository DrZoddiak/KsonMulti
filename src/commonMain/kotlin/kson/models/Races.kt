package kson.models

import kotlinx.serialization.Serializable

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
    val starting_proficiency_options : Choice,
    val languages: List<APIReference>,
    val language_desc: String,
    val traits: List<APIReference>,
    val subraces: List<APIReference>,
    override val url: String
) : DefaultTrait

@Serializable
data class AbilityBonuses(
    val ability_score: List<APIReference>,
    val bonus: Int
)