package kson.models

import kotlinx.serialization.Serializable

@Serializable
data class MagicSchools(
    override val index: String,
    override val name: String,
    override val desc: List<String>,
    override val url: String
) : GameMechanics