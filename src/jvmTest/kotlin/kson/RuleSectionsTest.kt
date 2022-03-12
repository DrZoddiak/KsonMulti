package kson

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kson.models.RuleSections
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RuleSectionsTest {
    @Test
    fun ruleSectionsGenerate() = runTest {
        val query = api.query<RuleSections>("")
        val result = query.results.indexes()
        println(result)
    }

    private val list = listOf(
        "ability-checks",
        "ability-scores-and-modifiers",
        "actions-in-combat",
        "advantage-and-disadvantage",
        "between-adventures",
        "casting-a-spell",
        "cover",
        "damage-and-healing",
        "diseases",
        "fantasy-historical-pantheons",
        "madness",
        "making-an-attack",
        "mounted-combat",
        "movement",
        "movement-and-position",
        "objects",
        "poisons",
        "proficiency-bonus",
        "resting",
        "saving-throws",
        "sentient-magic-items",
        "standard-exchange-rates",
        "the-environment",
        "the-order-of-combat",
        "the-planes-of-existence",
        "time",
        "traps",
        "underwater-combat",
        "using-each-ability",
        "what-is-a-spell"
    )

    @Test
    fun ruleSectionsRoute() = runTest {
        for (search in list) {
            val result = api.fetch<RuleSections>(search)
            println(result)
        }
    }

}