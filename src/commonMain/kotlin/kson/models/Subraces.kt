package kson.models

import kotlinx.serialization.Serializable

@Serializable
data class Subraces(
    val ability_bonuses: List<AbilityBonus>,
    val desc: String,
    override val index: String,
    val language_options: LanguageOption,
    override val name: String,
    val race: APIReference,
    val racial_traits: List<APIReference>,
    val starting_proficiencies: List<APIReference>,
    override val url: String
) : DefaultTrait

@Serializable
data class AbilityBonus(
    val ability_score: APIReference,
    val bonus: Int,
)

@Serializable
data class LanguageOption(
    val choose: Int? = null,
    val from: List<APIReference>,
    val type: String? = null
)