package kson.models

import kotlinx.serialization.Serializable

@Serializable
data class WeaponProperties(
    override val index: String,
    override val name: String,
    val desc: List<String>,
    override val url: String
) : DefaultTrait