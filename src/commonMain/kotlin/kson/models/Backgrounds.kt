package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kson.models.common.APIReference
import kson.models.common.Choice
import kson.models.common.IRef

@Serializable
data class Backgrounds(
    override val index: String,
    override val name: String,
    override val url: String,
    @SerialName("starting_proficiencies")
    val startingProficiencies: List<APIReference>,
    @SerialName("starting_equipment")
    val startingEquipment: List<StartingEquipment>,
    @SerialName("starting_equipment_options")
    val startingEquipmentOptions: List<Choice>,
    @SerialName("language_options")
    val languageOptions: Choice,
    val feature: Feature,
    @SerialName("personality_traits")
    val personalityTraits: Choice,
    val ideals: Choice,
    val bonds: Choice,
    val flaws: Choice
) : IRef

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
