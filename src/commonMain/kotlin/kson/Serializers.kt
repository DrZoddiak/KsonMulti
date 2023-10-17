package kson

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kson.models.ActionAction
import kson.models.common.Option
import kson.models.common.OptionSetType

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
            else -> throw SerializationException("Unable to find serializer")
        }
    }
}

object SetTypeSerializer : JsonContentPolymorphicSerializer<OptionSetType>(OptionSetType::class) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<OptionSetType> {
        return when {
            "options" in element.jsonObject -> OptionSetType.Array.serializer()
            "equipment_category" in element.jsonObject -> OptionSetType.Equipment.serializer()
            "resource_list_url" in element.jsonObject -> OptionSetType.ResourceList.serializer()
            else -> throw SerializationException("Unable to find serializer")
        }
    }
}

object CountSerializer : JsonContentPolymorphicSerializer<ActionAction>(ActionAction::class) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<ActionAction> {
        val count = element.jsonObject["count"]?.jsonPrimitive
        return when {
            count?.isString == true -> ActionAction.StringCount.serializer()
            count?.intOrNull != null -> ActionAction.IntCount.serializer()
            else -> throw SerializationException("Unable to find serializer")
        }
    }
}