package kson.models.common

import kotlinx.serialization.Serializable

@Serializable
data class Choice(
    val desc: String? = null,
    val choose: Int,
    val type: String,
    val from: OptionSetType,
)