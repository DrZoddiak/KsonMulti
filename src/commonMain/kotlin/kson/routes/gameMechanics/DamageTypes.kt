package kson.routes.gameMechanics

import kotlinx.serialization.Serializable
import kson.routes.DefaultTrait

@Serializable
data class DamageTypes( //Should work for damage-types as well
    override val index: String?,
    override val name: String?,
    override val desc: List<String>?,
    override val url: String?
) : GameMechanics