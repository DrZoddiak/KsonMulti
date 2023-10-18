package kson.serializer

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kson.models.ActionAction

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