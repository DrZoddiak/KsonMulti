package kson.models.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kson.models.common.serializer.SetTypeSerializer

/**
 * This represents an [OptionSet](https://5e-bits.github.io/docs/docs/reference/schemas#optionset)
 */
@Serializable(with = SetTypeSerializer::class)
sealed class OptionSetType {

    abstract val optionSetType: String

    @Serializable
    @SerialName("options_array")
    data class Array(
        override val optionSetType: String,
        val options: List<Option>
    ) : OptionSetType()

    @Serializable
    @SerialName("equipment_category")
    data class Equipment(
        override val optionSetType: String,
        val equipmentCategory: APIReference
    ) : OptionSetType()

    @Serializable
    @SerialName("resource_list")
    data class ResourceList(
        override val optionSetType: String,
        val resourceListUrl: String
    ) : OptionSetType()
}