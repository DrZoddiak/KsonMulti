package kson.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Backgrounds(
    override val index: String,
    override val name: String,
    val starting_proficiencies: List<APIReference>,
    val language_options: BackgroundOptions,
    val starting_equipment: List<EquipmentContent>,
    val starting_equipment_options: BackgroundOptions,
    val feature: Feature,
    val personality_traits: TextList,
    val ideals: IdealsOptions,
    val bonds: TextList,
    val flaws: TextList,
    override val url: String

) : DefaultTrait {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

@Serializable
data class BackgroundOptions(
    override val choose: String,
    override val type: String,
    override val from: List<APIReference>,
) : Options {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

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
data class TextList(
    override val choose: String,
    override val type: String,
    override val from: List<String>
) : Options {
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
data class EquipmentContent(
    val equipment: List<APIReference>,
    val quantity: String
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

