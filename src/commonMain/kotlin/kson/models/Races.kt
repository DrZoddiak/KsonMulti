package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import kson.models.common.Queryable
import kson.models.common.APIReference
import kson.models.common.Choice
import kson.models.common.IRef

@Serializable
data class Races(
    override val index: String,
    override val name: String,
    override val url: String,
    val speed: Int,
    @SerialName("ability_bonuses")
    val abilityBonuses: List<AbilityBonuses>,
    @SerialName("ability_bonus_options")
    val abilityBonusOptions: JsonObject? = null,
    val alignment: String,
    val age: String,
    val size: String,
    @SerialName("size_description")
    val sizeDescription: String,
    @SerialName("starting_proficiencies")
    val startingProficiencies: List<APIReference>,
    @SerialName("starting_proficiency_options")
    val startingProficiencyOptions: JsonObject? = null,
    val languages: List<APIReference>,
    @SerialName("language_desc")
    val languageDesc: String,
    val traits: List<APIReference>,
    val subraces: List<APIReference>,
    @SerialName("language_options")
    val languageOptions: Choice? = null,
) : IRef {
    companion object : Queryable
}

@Serializable
data class AbilityBonuses(
    @SerialName("ability_score")
    val abilityScore: APIReference,
    val bonus: Int
)