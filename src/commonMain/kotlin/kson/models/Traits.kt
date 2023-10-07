package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject

@Serializable
data class Traits(
    val index: String,
    val races: List<APIReference>,
    val subraces: List<APIReference>,
    val name: String,
    val parent: APIReference? = null,
    val desc: List<String>,
    val proficiencies: List<APIReference>,
    val proficiency_choices: JsonObject? = null,
    val trait_specific: TraitSpecific? = null,
    val url: String
)


@Serializable
data class TraitSpecific(
    val subtrait_options: JsonObject? = null,
    val spell_options: JsonObject? = null,
    val damage_type: APIReference? = null,
    val breath_weapon: ActionContent? = null
)

@Serializable
data class ActionContent(
    val name: String? = null,
    val desc: String? = null,
    val usage: Usage? = null,
    val dc: TraitDC? = null,
    val damage: List<ActionDamageContent>
)

@Serializable
data class Usage(
    val type: String,
    val time: String? = null
)

@Serializable
data class TraitDC(
    val dc_type: APIReference,
    val success_type: String
)

@Serializable
data class ActionDamageContent(
    val damage_type: APIReference,
    val damage_at_character_level: TraitLevelDamage
)

@Serializable
data class TraitLevelDamage(
    @SerialName("1")
    val one: String,
    @SerialName("6")
    val six: String,
    @SerialName("11")
    val eleven: String,
    @SerialName("16")
    val sixteen: String
)