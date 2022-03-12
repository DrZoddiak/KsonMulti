package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Backgrounds(
    override val index: String,
    override val name: String,
    val starting_proficiencies: List<APIReference>,
    val language_options: LanguageOptions,
    val starting_equipment: List<EquipmentContent>,
    val starting_equipment_options: List<StartingEquipmentOptions>,
    val feature: Feature,
    val personality_traits: CharacteristicOptions,
    val ideals: IdealsOptions,
    val bonds: CharacteristicOptions,
    val flaws: CharacteristicOptions,
    override val url: String

) : DefaultTrait {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

@Serializable
data class LanguageOptions(
    val choose: Int,
    val from: List<APIReference>,
    val type: String
)

@Serializable
data class StartingEquipmentOptions(
    val choose: Int,
    val type: String,
    val from: List<StartingEquipmentOption>,
) {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

@Serializable
data class StartingEquipmentOption(
    val equipment: APIReference? = null,
    val quantity: Int? = null
)

@Serializable
data class IdealsOptions(
    override val choose: String,
    override val type: String,
    override val from: List<IdealsFrom>
) : Options {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

@Serializable
data class CharacteristicOptions(
    val choose: Int,
    val type: String,
    val from: List<String>
) {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

@Serializable
data class IdealsFrom(
    val desc: String,
    val alignments: List<APIReference>
) {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

@Serializable
@SerialName("Equipment")
data class EquipmentContent(
    val equipment: APIReference,
    val quantity: Int
) {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

@Serializable
data class Feature(
    val name: String,
    val desc: List<String>
) {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

