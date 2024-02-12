package kson.models.common

import kotlinx.serialization.Serializable

/**
 * Represents [Damage](https://5e-bits.github.io/docs/docs/reference/schemas#damage)
 */
@Serializable
data class Damage(
    val damageType: APIReference,
    val damageDice: String
)