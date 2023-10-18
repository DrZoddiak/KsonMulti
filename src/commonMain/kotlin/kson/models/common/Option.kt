package kson.models.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kson.models.common.serializer.OptionSerializer

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
        @SerialName("option_type")
        override val optionType: String,
        @SerialName("action_name")
        val actionName: String,
        val count: Int,
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
        val choice: kson.models.common.Choice
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
        val damage: List<kson.models.common.Damage>? = null
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