package kson.serializer

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kson.models.common.OptionSetType

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
