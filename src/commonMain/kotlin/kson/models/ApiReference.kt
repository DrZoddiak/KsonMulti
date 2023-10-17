package kson.models

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject

interface IRef {
    val name: String
    val index: String
    val url: String
}

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
    @Serializable
    @SerialName("options_array")
    data class Array(
        val options: List<Option>
    ) : OptionSet()

    @Serializable
    @SerialName("equipment_category")
    data class Equipment(
        @SerialName("equipment_category")
        val equipmentCategory: APIReference
    ) : OptionSet()

    @Serializable
    @SerialName("resource_list")
    data class ResourceList(
        @SerialName("resource_list_url")
        val resourceListUrl: String
    ) : OptionSet()
}

@Serializable(with = OptionSerializer::class)
sealed class Option {
    @Serializable
    data class Reference(val item: APIReference) : Option()

    @Serializable
    data class Action(
        @SerialName("action_name")
        val actionName: String,
        val count: String,
        val type: String //todo: enum
    ) : Option()

    @Serializable
    data class Multiple(
        val items: List<Option>
    ) : Option()

    @Serializable
    data class Choice(val choice: kson.models.Choice) : Option()

    @Serializable
    data class StringOption(val string: String) : Option()

    @Serializable
    data class Ideal(
        val desc: String,
        val alignments: APIReference
    ) : Option()

    @Serializable
    data class CountedReference(
        val count: Int,
        val of: APIReference
    ) : Option()

    @Serializable
    data class ScorePrerequisite(
        @SerialName("ability_score")
        val abilityScore: APIReference,
        @SerialName("minimum_score")
        val minimumScore: Int
    ) : Option()

    @Serializable
    data class AbilityBonus(
        @SerialName("ability_bonus")
        val abilityScore: APIReference,
        val bonus: Int
    ) : Option()

    @Serializable
    data class Breath(
        val name: StringOption,
        val dc: DC,
        val damage: List<Damage>
    ) : Option()

    @Serializable
    data class Damage(
        @SerialName("damage_type")
        val damageType: APIReference,
        @SerialName("damage_dice")
        val damageDice: String,
        val notes: String
    ) : Option()
}

object OptionSerializer : JsonContentPolymorphicSerializer<Option>(Option::class) {

    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<Option> {
        return when {
            "item" in element.jsonObject -> Option.Reference.serializer()
            "action_name" in element.jsonObject -> Option.Action.serializer()
            "items" in element.jsonObject -> Option.Multiple.serializer()
            "choice" in element.jsonObject -> Option.Choice.serializer()
            "string" in element.jsonObject -> Option.StringOption.serializer()
            "alignments" in element.jsonObject -> Option.Ideal.serializer()
            "count" in element.jsonObject -> Option.CountedReference.serializer()
            "minimum_score" in element.jsonObject -> Option.ScorePrerequisite.serializer()
            "bonus" in element.jsonObject -> Option.AbilityBonus.serializer()
            "dc" in element.jsonObject -> Option.Breath.serializer()
            "damage_type" in element.jsonObject -> Option.Damage.serializer()
            else -> Option.serializer() //todo: Throw error?
        }
    }
}

object SetTypeSerializer : JsonContentPolymorphicSerializer<OptionSet>(OptionSet::class) {

    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<OptionSet> {
        return when {
            "options" in element.jsonObject -> OptionSet.Array.serializer()
            "equipment_category" in element.jsonObject -> OptionSet.Equipment.serializer()
            "resource_list_url" in element.jsonObject -> OptionSet.ResourceList.serializer()
            else -> OptionSet.serializer() //todo: Throw error?
        }
    }
}