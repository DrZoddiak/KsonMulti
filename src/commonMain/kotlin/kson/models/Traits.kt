package kson.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject

@Serializable
data class Traits(
    override val index: String,
    val races: List<APIReference>,
    val subraces: List<String>,
    override val name: String,
    val desc: List<String>,
    val proficiencies: List<String>,
    val proficiency_choices: Choice,
    val trait_specific: TraitSpecific,
    override val url: String
) : DefaultTrait {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

@Serializable
data class TraitSpecific(
    val subtrait_options: Choice,
    val spell_options: Choice,
    val damage_type: APIReference,
    val breath_weapon: JsonObject
) {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}