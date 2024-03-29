package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kson.models.common.Queryable
import kson.models.common.APIReference
import kson.models.common.Choice
import kson.models.common.DC
import kson.models.common.IRef
import kson.models.common.OptionSetType
import kson.models.common.serializer.CountSerializer

@Serializable
data class Monsters(
    override val index: String,
    override val name: String,
    override val url: String,
    val desc: String? = null,
    val charisma: Int,
    val strength: Int,
    val constitution: Int,
    val dexterity: Int,
    val wisdom: Int,
    val intelligence: Int,
    val image: String? = null,
    val size: String,
    val type: String,
    val subtype: String? = null,
    val alignment: String,
    val armorClass: List<AC>,
    val hitPoints: Int,
    val hitDice: String,
    val hitPointsRoll: String,
    val forms: List<APIReference>? = null,
    val speed: Speed,
    val proficiencies: List<ProficienciesOptions>,
    val damageVulnerabilities: List<String>,
    val damageResistances: List<String>,
    val damageImmunities: List<String>,
    val conditionImmunities: List<APIReference>,
    val senses: Sense,
    val languages: String,
    val challengeRating: Double,
    val proficiencyBonus: Int,
    val specialAbilities: List<SpecialAbility>? = null,
    val actions: List<Action>? = null,
    val legendaryActions: List<LegendaryAction>? = null,
    val reactions: List<Reaction>? = null,
    val xp: Int
) : IRef {
    companion object : Queryable {
        fun challengeRating(vararg double: Double) = query("challenge_rating", double.joinToString(","))
    }
}

@Serializable
data class AC(
    val type: String,
    val value: Int,

    val condition: APIReference? = null,
    val spell: APIReference? = null,
    val armor: List<APIReference>? = null,
    val desc: String? = null,
)

@Serializable
data class LegendaryAction(
    val name: String,
    val desc: String,
    val attackBonus: Int? = null,
    val damage: List<ActionDamage>? = null,
    val dc: DC? = null
)

@Serializable
data class SpecialAbility(
    val name: String,
    val desc: String,
    val attackBonus: Int? = null,
    val damage: List<ActionDamage>? = null,
    val dc: DC? = null,
    val spellcasting: SpecialAbilitySpellcasting? = null,
    val usage: SpecialAbilityUsage? = null
)

@Serializable
data class SpecialAbilitySpellcasting(
    val level: Int? = null,
    val ability: APIReference,
    val dc: Int? = null,
    val modifier: Int? = null,
    val componentsRequired: List<String>,
    val school: String? = null,
    val slots: Slots? = null,
    val spells: List<SpecialAbilitySpell>
)

@Serializable
data class SpecialAbilitySpell(
    val name: String,
    val level: Int,
    val url: String,
    val notes: String? = null,
    val usage: SpecialAbilityUsage? = null
)

@Serializable
data class SpecialAbilityUsage(
    val type: String,
    val times: Int? = null,
    val restTypes: List<String>? = null
)

@Serializable
data class Slots(
    //Name is numerical, but kotlin doesn't support numerical names.
    @SerialName("1")
    val one: Int,
    @SerialName("2")
    val two: Int? = null,
    @SerialName("3")
    val three: Int? = null,
    @SerialName("4")
    val four: Int? = null,
    @SerialName("5")
    val five: Int? = null,
    @SerialName("6")
    val six: Int? = null,
    @SerialName("7")
    val seven: Int? = null,
    @SerialName("8")
    val eight: Int? = null,
    @SerialName("9")
    val nine: Int? = null,
)

@Serializable
data class Sense(
    val blindsight: String? = null,
    val darkvision: String? = null,
    val passivePerception: Int,
    val tremorsense: String? = null,
    val truesight: String? = null
)

@Serializable
data class Speed(
    val burrow: String? = null,
    val climb: String? = null,
    val fly: String? = null,
    val hover: Boolean? = null,
    val swim: String? = null,
    val walk: String? = null,
    val quantity: Double? = null,
    val unit: String? = null,
)

@Serializable
data class ProficienciesOptions(
    val proficiency: APIReference,
    val value: Int
)

@Serializable
data class Reaction(
    val name: String,
    val desc: String,
    val dc: DC? = null
)

@Serializable
data class Action(
    val name: String,
    val desc: String,
    val actionOptions: Choice? = null,
    val actions: List<ActionAction>,
    val options: Choice? = null,
    val multiattackType: String? = null,
    val attackBonus: Int? = null,
    val dc: DC? = null,
    val damage: List<ActionDamage>? = null,
    val attacks: List<ActionAttack>? = null,
    val usage: ActionUsage? = null,
)

@Serializable(with = CountSerializer::class)
sealed class ActionAction {
    @Serializable
    data class StringCount(
        val actionName: String,
        val count: String,
        val type: String,
    ) : ActionAction()

    @Serializable
    data class IntCount(
        val actionName: String,
        val count: Int,
        val type: String,
    ) : ActionAction()
}


@Serializable
data class ActionAttack(
    val name: String,
    val dc: DC,
    val damage: List<ActionDamage>? = null
)

@Serializable
data class ActionDamage(
    val damageDice: String? = null,
    val damageType: APIReference? = null,
    val dc: DC? = null,
    val desc: String? = null,
    val choose: Int? = null,
    val type: String? = null,
    val from: OptionSetType? = null,
)

@Serializable
data class ActionUsage(
    val type: String,
    val dice: String? = null,
    val minValue: Int? = null,
    val times: Int? = null,
    val restTypes: List<String>? = null
)