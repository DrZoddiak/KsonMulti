package kson.routes

import kotlinx.serialization.Serializable

@Serializable
data class Backgrounds(
    override val index: String?,
    override val name: String?,
    val starting_proficiencies: List<APIReference?>?,
    val language_options: BackgroundOptions?,
    val starting_equipment: List<EquipmentContent?>?,
    val starting_equipment_options: BackgroundOptions?,
    val feature: Feature?,
    val personality_traits: TextList?,
    val ideals: IdealsOptions?,
    val bonds: TextList?,
    val flaws: TextList?,
    override val url: String?

) : DefaultTrait

@Serializable
data class BackgroundOptions(
    override val choose: String?,
    override val type: String?,
    override val from: List<DefaultTrait?>?,
) : Options

@Serializable
data class IdealsOptions(
    override val choose: String?,
    override val type: String?,
    override val from: List<IdealsFrom?>?
) : Options

@Serializable
data class TextList(
    override val choose: String?,
    override val type: String?,
    override val from: List<String?>?
) : Options

@Serializable
data class IdealsFrom(
    val desc: String?,
    val alignments: List<DefaultTrait?>?
)

@Serializable
data class EquipmentContent(
    val equipment: List<DefaultTrait?>?,
    val quantity: String?
)

@Serializable
data class Feature(
    val name: String?,
    val desc: List<String?>?
)

