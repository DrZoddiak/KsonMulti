package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject

@Serializable
data class Monsters(
    val index: String,
    val name: String,
    val url: String,
    val desc: String? = null,
    val charisma: Int,
    val strength: Int,
    val constitution: Int,
    val dexterity: Int,
    val wisdom: Int,
    val intelligence: Int,
    val image : String? = null,
    val size: String,
    val type: String,
    val subtype: String? = null,
    val alignment: String,
    val armor_class: JsonArray,
    val hit_points: Int,
    val hit_dice: String,
    val forms: List<APIReference>? = null,
    val speed: Speed,
    val proficiencies: List<ProficienciesOptions>,
    val damage_vulnerabilities: List<String>,
    val damage_resistances: List<String>,
    val damage_immunities: List<String>,
    val condition_immunities: List<APIReference>,
    val senses: Sense,
    val languages: String,
    val challenge_rating: Double,
    val special_abilities: List<SpecialAbility>? = null,
    val actions: List<Action>? = null,
    val legendary_actions: List<LegendaryAction>? = null,
    val reactions: List<Reaction>? = null,
    val xp: Int

)

@Serializable
data class LegendaryAction(
    val name: String,
    val desc: String,
    val attack_bonus: Int? = null,
    val damage: List<ActionDamage>? = null,
    val dc: ActionDC? = null
)

@Serializable
data class SpecialAbility(
    val name: String,
    val desc: String,
    val attack_bonus: Int? = null,
    val damage: List<ActionDamage>? = null,
    val dc: ActionDC? = null,
    val spellcasting: SpecialAbilitySpellcasting? = null,
    val usage: SpecialAbilityUsage? = null
)
@Serializable
data class SpecialAbilitySpellcasting(
    val level: Int? = null,
    val ability: APIReference,
    val dc: Int? = null,
    val modifier: Int? = null,
    val components_required: List<String>,
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
    val rest_types: List<String>? = null
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
    val passive_perception: Int,
    val tremorsense: String? = null,
    val truesight: String? = null
)

@Serializable
data class Speed(
    val burrow: String? = null,
    val climb: String? = null,
    val fly: String? = null,
    val hover: String? = null,
    val swim: String? = null,
    val walk: String? = null
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
    val dc: ActionDC? = null
)

@Serializable
data class ActionDC(
    val dc_type: APIReference,
    val dc_value: Int,
    val success_type: String
)

@Serializable
data class Action(
    val name: String,
    val desc: String,
    val attack_bonus: Int? = null,
    val damage: List<ActionDamage>? = null,
    val dc: ActionDC? = null,
    val options: JsonObject? = null,
    val usage: ActionUsage? = null,
    val attack_options: ActionAttackOptions? = null,
    val attacks: List<ActionAttack>? = null
)

@Serializable
data class ActionAttack(
    val name: String,
    val dc: ActionDC,
    val damage: List<ActionDamage>? = null
)

@Serializable
data class ActionDamage(
    val damage_dice: String? = null,
    val damage_type: APIReference? = null
)

@Serializable
data class ActionAttackOptions(
    val choose: Int,
    val type: String,
    val from: List<ActionAttack>
)

@Serializable
data class ActionOption(
    val name: String? = null,
    val count: String? = null,
    val type: String? = null
)

@Serializable
data class ActionOptions(
    val choose: Int,
    val from: List<ActionOption>
)

@Serializable
data class ActionUsage(
    val type: String,
    val dice: String? = null,
    val min_value: Int? = null
)