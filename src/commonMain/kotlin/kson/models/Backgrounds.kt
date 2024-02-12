package kson.models

import kotlinx.serialization.Serializable
import kson.models.common.Queryable
import kson.models.common.APIReference
import kson.models.common.Choice
import kson.models.common.IRef

@Serializable
data class Backgrounds(
    override val index: String,
    override val name: String,
    override val url: String,
    val startingProficiencies: List<APIReference>,
    val startingEquipment: List<StartingEquipment>,
    val startingEquipmentOptions: List<Choice>,
    val languageOptions: Choice,
    val feature: Feature,
    val personalityTraits: Choice,
    val ideals: Choice,
    val bonds: Choice,
    val flaws: Choice
) : IRef {
    companion object : Queryable
}

@Serializable
data class StartingEquipment(
    val quantity: Int,
    val equipment: APIReference
)

@Serializable
data class Feature(
    val name: String,
    val desc: List<String>
)
