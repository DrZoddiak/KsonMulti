package kson.models

import kotlinx.serialization.Serializable
import kson.APIReference
import kson.DefaultTrait
import kson.Options

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

) : DefaultTrait

@Serializable
data class BackgroundOptions(
    override val choose: String,
    override val type: String,
    override val from: List<APIReference>,
) : Options

@Serializable
data class IdealsOptions(
    override val choose: String,
    override val type: String,
    override val from: List<IdealsFrom>
) : Options

@Serializable
data class TextList(
    override val choose: String,
    override val type: String,
    override val from: List<String>
) : Options

@Serializable
data class IdealsFrom(
    val desc: String,
    val alignments: List<APIReference>
)

@Serializable
data class EquipmentContent(
    val equipment: List<APIReference>,
    val quantity: String
)

@Serializable
data class Feature(
    val name: String,
    val desc: List<String>
)

