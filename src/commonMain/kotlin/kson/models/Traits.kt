package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kson.models.common.Queryable
import kson.models.common.APIReference
import kson.models.common.Choice
import kson.models.common.DC
import kson.models.common.IRef

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
    val proficiencyChoices: Choice? = null,
    val traitSpecific: TraitSpecific? = null,
    val languageOptions: Choice? = null,
) : IRef {
    companion object : Queryable
}

@Serializable
data class TraitSpecific(
    val subtraitOptions: Choice? = null,
    val spellOptions: Choice? = null,
    val damageType: APIReference? = null,
    val breathWeapon: ActionContent? = null
)

@Serializable
data class ActionContent(
    val name: String? = null,
    val desc: String? = null,
    val areaOfEffect: AreaOfEffect,
    val usage: Usage? = null,
    val dc: DC? = null,
    val damage: List<ActionDamageContent>
)

@Serializable
data class Usage(
    val type: String,
    val times: Int? = null
)

@Serializable
data class ActionDamageContent(
    val damageType: APIReference,
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