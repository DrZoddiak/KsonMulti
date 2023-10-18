package kson.serializer

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kson.models.common.Option

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