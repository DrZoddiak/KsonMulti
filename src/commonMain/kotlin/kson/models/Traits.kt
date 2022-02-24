package kson.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import kson.APIReference
import kson.Choice
import kson.DefaultTrait

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
) : DefaultTrait

@Serializable
data class TraitSpecific(
    val subtrait_options : Choice,
    val spell_options : Choice,
    val damage_type : APIReference,
    val breath_weapon : JsonObject
)