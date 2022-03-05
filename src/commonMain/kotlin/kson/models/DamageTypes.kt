package kson.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class DamageTypes( //Should work for damage-types as well
    override val index: String,
    override val name: String,
    override val desc: List<String>,
    override val url: String
) : GameMechanics {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}