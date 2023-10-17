package kson.models.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Damage(
    @SerialName("damage_type")
    val damageType: APIReference,
    @SerialName("damage_dice")
    val damageDice: String
)