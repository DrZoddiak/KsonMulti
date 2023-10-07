package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class Backgrounds(
    val index: String,
    val name: String,
    val url: String,
    @SerialName("starting_proficiencies")
    val startingProficiencies: List<APIReference>,
    @SerialName("starting_equipment")
    val startingEquipment: List<EquipmentContent>,
    @SerialName("starting_equipment_options")
    val startingEquipmentOptions: List<Choice>,
    @SerialName("language_options")
    val languageOptions: Choice,
    val feature: Feature,
    @SerialName("personality_traits")
    val personalityTraits: JsonObject, //Choice
    val ideals: Choice,
    val bonds: Choice,
    val flaws: Choice
)

@Serializable
data class LanguageOptions(
    val desc: String,
    val choose: Int,
    val type: String,
    val from: JsonObject //todo : Option Set
)

@Serializable
data class StartingEquipmentOptions(
    val choose: Int,
    val type: String,
    val from: List<StartingEquipmentOption>,
)

@Serializable
data class StartingEquipmentOption(
    val equipment: APIReference? = null,
    val quantity: Int? = null
)

@Serializable
data class IdealsOptions(
    val choose: String,
    val type: String,
    val from: List<IdealsFrom>
)

@Serializable
data class CharacteristicOptions(
    val choose: Int,
    val type: String,
    val from: List<String>
)

@Serializable
data class IdealsFrom(
    val desc: String,
    val alignments: List<APIReference>
)

@Serializable
data class EquipmentContent(
    val equipment: APIReference,
    val quantity: Int
)

@Serializable
data class Feature(
    val name: String,
    val desc: List<String>
)
