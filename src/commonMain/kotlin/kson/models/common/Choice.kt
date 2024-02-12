package kson.models.common

import kotlinx.serialization.Serializable

/**
 * Represents a [Choice](https://5e-bits.github.io/docs/docs/reference/schemas#choice)
 */
@Serializable
data class Choice(
    val desc: String? = null,
    val choose: Int,
    val type: String,
    val from: OptionSetType,
)