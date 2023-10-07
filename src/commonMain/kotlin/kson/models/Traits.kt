package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject

@Serializable
data class Traits(
    override val index: String,
    override val name: String,
    override val url: String,
    val races: List<APIReference>,
    val subraces: List<APIReference>,
    val parent: APIReference? = null,
    val desc: List<String>,
    val proficiencies: List<APIReference>,
    @SerialName("proficiency_choices")
    val proficiencyChoices: JsonObject? = null,
    @SerialName("trait_specific")
    val traitSpecific: TraitSpecific? = null
): IRef


@Serializable
data class TraitSpecific(
    @SerialName("subtrait_options")
    val subtraitOptions: JsonObject? = null,
    @SerialName("spell_options")
    val spellOptions: JsonObject? = null,
    @SerialName("damage_type")
    val damageType: APIReference? = null,
    @SerialName("breath_weapon")
    val breathWeapon: ActionContent? = null
)

@Serializable
data class ActionContent(
    val name: String? = null,
    val desc: String? = null,
    val usage: Usage? = null,
    val dc: DC? = null,
    val damage: List<ActionDamageContent>
)

@Serializable
data class Usage(
    val type: String,
    val time: String? = null
)

@Serializable
data class ActionDamageContent(
    @SerialName("damage_type")
    val damageType: APIReference,
    @SerialName("damage_at_character_level")
    val damageAtCharacterLevel: TraitLevelDamage
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