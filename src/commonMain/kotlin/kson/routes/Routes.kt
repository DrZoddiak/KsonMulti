package kson.routes

import kotlinx.serialization.Serializable
import kson.routes.characterData.AbilityScores
import kotlin.reflect.KClass

enum class Routes(kClass: KClass<out Fetchable>) {
    ABILITY_SCORES(AbilityScores::class),
    ALIGNMENTS,
    BACKGROUNDS,
    CLASSES,
    CONDITIONS,
    DAMAGE_TYPES,
    EQUIPMENT,
    EQUIPMENT_CATEGORIES,
    FEATURES,
    LANGUAGES,
    MAGIC_ITEMS,
    MAGIC_SCHOOLS,
    MONSTERS(Monsters::class),
    PROFICIENCIES,
    RACES,
    RULES_SECTIONS,
    RULES,
    SKILLS,
    SUBCLASSES,
    TRAITS,
    WEAPON_PROPERTIES;

    val fetchableClass: KClass<out Fetchable>

    init {
        this.fetchableClass = kClass
    }

    companion object {
        fun contains(name: String) = values().contains(valueOf(name.uppercase()))
    }
}

abstract class Fetchable () {

}

fun test () {
    Routes.MONSTERS.fetchableClass
}

@Serializable
data class DefaultRequest(
    var count: Int?,
    var results: List<APIReference?>?
)

@Serializable
data class APIReference(
    override val index: String?,
    override val name: String?,
    override val url: String?
) : DefaultTrait


@Serializable
data class Choice(
    val choose: Int?,
    val type: String?,
    val from: List<APIReference?>?
)

@Serializable
data class Cost(
    val quantity: Int?,
    val unit: String?
)

@Serializable
data class AbilityBonus(
    val bonus: Int?,
    val ability_score: APIReference?
)

interface DefaultTrait {
    val index: String?
    val name: String?
    val url: String?
}

interface Options {
    val choose: String?
    val type: String?
    val from: Collection<*>?
}