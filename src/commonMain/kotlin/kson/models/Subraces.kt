package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kson.models.common.Queryable
import kson.models.common.APIReference
import kson.models.common.Choice
import kson.models.common.IRef

@Serializable
data class Subraces(
    override val index: String,
    override val name: String,
    override val url: String,
    val desc: String,
    val race: APIReference,
    val abilityBonuses: List<AbilityBonus>,
    val startingProficiencies: List<APIReference>,
    val languages: List<APIReference>,
    val languageOptions: Choice? = null,
    val racialTraits: List<APIReference>
) : IRef {
    companion object : Queryable
}

@Serializable
data class AbilityBonus(
    @SerialName("ability_score")
    val abilityScore: APIReference,
    val bonus: Int,
)
