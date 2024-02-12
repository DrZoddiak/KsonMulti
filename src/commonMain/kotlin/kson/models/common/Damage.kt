package kson.models.common

import kotlinx.serialization.Serializable

@Serializable
data class Damage(
    val damageType: APIReference,
    val damageDice: String
)