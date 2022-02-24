package kson.models

import kotlinx.serialization.Serializable

@Serializable
data class Conditions( //Should work for damage-types as well
    override val index: String,
    override val name: String,
    override val desc: List<String>,
    override val url: String
) : GameMechanics