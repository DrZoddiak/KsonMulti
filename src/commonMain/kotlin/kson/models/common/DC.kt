package kson.models.common

import kotlinx.serialization.Serializable

/**
 * Represents a [Difficulty Check (DC)](https://5e-bits.github.io/docs/docs/reference/schemas#difficulty-check-dc)
 */
@Serializable
data class DC(
    val dcType: APIReference,
    val dcValue: Int? = null,
    val successType: SuccessType? = null
)

@Serializable
enum class SuccessType {
    none, half, other
}