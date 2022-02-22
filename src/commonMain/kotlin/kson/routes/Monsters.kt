package kson.routes

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class Monsters(
    val index: String?,
    val name: String?,
    val size: String?,
    val type: String?,
    val subtype: String?,
    val alignment: String?,
    val armor_class: Int?,
    val hit_points: Int?,
    val hit_dice: String?,
    val forms: List<APIReference?>? = null,
    val speed: JsonObject?,
    val strength: Int?,
    val dexterity: Int?,
    val constitution: Int?,
    val intelligence: Int?,
    val wisdom: Int?,
    val charisma: Int?,
    val proficiencies: List<ProficienciesOptions?>?,
    val damage_vulnerabilities: List<String?>?,
    val damage_resistances: List<String?>?,
    val damage_immunities: List<String?>?,
    val condition_immunities: List<APIReference?>?,
    val senses: JsonObject?,
    val languages: String?,
    val challenge_rating: Double?,
    val special_abilities: List<JsonObject?>? = null,
    val actions: List<Weapons?>? = null,
    val legendary_actions: List<JsonObject?>? = null,
    val url: String?
) : Fetchable()

@Serializable
data class Weapons(
    val name: String?,
    val desc: String?,
    val attack_bonus: Int? = null,
    val damage: List<JsonObject?>?
)

@Serializable
data class ProficienciesOptions(
    val proficiency: APIReference?,
    val value: Int?
)