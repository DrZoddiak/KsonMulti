package kson.models.common

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kson.models.common.serializer.SetTypeSerializer

@Serializable(with = SetTypeSerializer::class)
sealed class OptionSetType {

    @SerialName("option_set_type")
    abstract val optionSetType: String

    @Serializable
    @SerialName("options_array")
    data class Array(
        @SerialName("option_set_type")
        override val optionSetType: String,
        val options: List<Option>
    ) : OptionSetType()

    @Serializable
    @SerialName("equipment_category")
    data class Equipment(
        @SerialName("option_set_type")
        override val optionSetType: String,
        @SerialName("equipment_category")
        val equipmentCategory: APIReference
    ) : OptionSetType()

    @Serializable
    @SerialName("resource_list")
    data class ResourceList(
        @SerialName("option_set_type")
        override val optionSetType: String,
        @SerialName("resource_list_url")
        val resourceListUrl: String
    ) : OptionSetType()
}