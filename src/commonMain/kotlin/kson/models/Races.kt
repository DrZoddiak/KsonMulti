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
    val abilityBonuses: List<AbilityBonuses>,
    val abilityBonusOptions: JsonObject? = null,
    val alignment: String,
    val age: String,
    val size: String,
    val sizeDescription: String,
    val startingProficiencies: List<APIReference>,
    val startingProficiencyOptions: JsonObject? = null,
    val languages: List<APIReference>,
    val languageDesc: String,
    val traits: List<APIReference>,
    val subraces: List<APIReference>,
    val languageOptions: Choice? = null,
) : IRef {
    companion object : Queryable
}

@Serializable
data class AbilityBonuses(
    val abilityScore: APIReference,
    val bonus: Int
)