package kson.models.common

import kotlinx.serialization.Serializable
import kson.models.common.serializer.OptionSerializer

@Serializable(with = OptionSerializer::class)
sealed class Option {

    abstract val optionType: String

    @Serializable
    data class Reference(
        override val optionType: String,
        val item: APIReference
    ) : Option()

    @Serializable
    data class Action(
        override val optionType: String,
        val actionName: String,
        val count: Int,
        val desc: String? = null,
        val type: String, //todo: enum
    ) : Option()

    @Serializable
    data class Multiple(
        override val optionType: String,
        val desc: String? = null,
        val items: List<Option>
    ) : Option()

    @Serializable
    data class Choice(
        override val optionType: String,
        val choice: kson.models.common.Choice
    ) : Option()

    @Serializable
    data class StringOption(
        override val optionType: String,
        val string: String
    ) : Option()

    @Serializable
    data class Ideal(
        override val optionType: String,
        val desc: String,
        val alignments: List<APIReference>
    ) : Option()

    @Serializable
    data class CountedReference(
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
        override val optionType: String,
        val abilityScore: APIReference,
        val minimumScore: Int
    ) : Option()

    @Serializable
    data class AbilityBonus(
        override val optionType: String,
        val abilityScore: APIReference,
        val bonus: Int
    ) : Option()

    @Serializable
    data class Breath(
        override val optionType: String,
        val name: String,
        val dc: DC,
        val damage: List<kson.models.common.Damage>? = null
    ) : Option()

    @Serializable
    data class Damage(
        override val optionType: String,
        val damageType: APIReference,
        val damageDice: String,
        val notes: String? = null
    ) : Option()
}