package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kson.OptionSerializer
import kson.SetTypeSerializer

interface IRef {
    val name: String
    val index: String
    val url: String
}

@Serializable
data class APIReference(
    override val index: String,
    override val name: String,
    override val url: String
) : IRef

@Serializable
data class DefaultRequest(
    val count: Int,
    val results: List<APIReference>
)

@Serializable
data class Cost(
    val quantity: Int,
    val unit: String
)

@Serializable
data class DC(
    @SerialName("dc_type")
    val dcType: APIReference,
    @SerialName("dc_value")
    val dcValue: Int? = null,
    @SerialName("success_type")
    val successType: String? = null
)

@Serializable
data class Damage(
    @SerialName("damage_type")
    val damageType: APIReference,
    @SerialName("damage_dice")
    val damageDice: String
)

@Serializable
data class Choice(
    val desc: String? = null,
    val choose: Int,
    val type: String,
    val from: OptionSet,
)

@Serializable(with = SetTypeSerializer::class)
sealed class OptionSet {

    @SerialName("option_set_type")
    abstract val optionSetType: String

    @Serializable
    @SerialName("options_array")
    data class Array(
        @SerialName("option_set_type")
        override val optionSetType: String,
        val options: List<Option>
    ) : OptionSet()

    @Serializable
    @SerialName("equipment_category")
    data class Equipment(
        @SerialName("option_set_type")
        override val optionSetType: String,
        @SerialName("equipment_category")
        val equipmentCategory: APIReference
    ) : OptionSet()

    @Serializable
    @SerialName("resource_list")
    data class ResourceList(
        @SerialName("option_set_type")
        override val optionSetType: String,
        @SerialName("resource_list_url")
        val resourceListUrl: String
    ) : OptionSet()
}

@Serializable(with = OptionSerializer::class)
sealed class Option {

    @SerialName("option_type")
    abstract val optionType: String

    @Serializable
    data class Reference(
        @SerialName("option_type")
        override val optionType: String,
        val item: APIReference
    ) : Option()

    @Serializable
    data class Action(
        @SerialName("action_name")
        val actionName: String,
        val count: Int,
        @SerialName("option_type")
        override val optionType: String,
        val desc: String? = null,
        val type: String, //todo: enum
    ) : Option()

    @Serializable
    data class Multiple(
        @SerialName("option_type")
        override val optionType: String,
        val desc: String? = null,
        val items: List<Option>
    ) : Option()

    @Serializable
    data class Choice(
        @SerialName("option_type")
        override val optionType: String,
        val choice: kson.models.Choice
    ) : Option()

    @Serializable
    data class StringOption(
        @SerialName("option_type")
        override val optionType: String,
        val string: String
    ) : Option()

    @Serializable
    data class Ideal(
        @SerialName("option_type")
        override val optionType: String,
        val desc: String,
        val alignments: List<APIReference>
    ) : Option()

    @Serializable
    data class CountedReference(
        @SerialName("option_type")
        override val optionType: String,
        val count: Int,
        val of: APIReference,
        val prerequisites: List<Prerequisite>? = null
    ) : Option()

    @Serializable
    data class Prerequisite(
        val type: String,
        val proficiency: APIReference
    )

    @Serializable
    data class ScorePrerequisite(
        @SerialName("option_type")
        override val optionType: String,
        @SerialName("ability_score")
        val abilityScore: APIReference,
        @SerialName("minimum_score")
        val minimumScore: Int
    ) : Option()

    @Serializable
    data class AbilityBonus(
        @SerialName("option_type")
        override val optionType: String,
        @SerialName("ability_bonus")
        val abilityScore: APIReference,
        val bonus: Int
    ) : Option()

    @Serializable
    data class Breath(
        @SerialName("option_type")
        override val optionType: String,
        val name: String,
        val dc: DC,
        val damage: List<kson.models.Damage>? = null
    ) : Option()

    @Serializable
    data class Damage(
        @SerialName("option_type")
        override val optionType: String,
        @SerialName("damage_type")
        val damageType: APIReference,
        @SerialName("damage_dice")
        val damageDice: String,
        val notes: String? = null
    ) : Option()
}