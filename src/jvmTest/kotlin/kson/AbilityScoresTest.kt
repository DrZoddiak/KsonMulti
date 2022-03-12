package kson

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kson.models.AbilityScores
import kotlin.test.Test

class AbilityScoresTest {
    private val abilityScores = listOf(
        "cha",
        "con",
        "dex",
        "int",
        "str",
        "wis"
    )

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun abilityScoresRoute() = runTest {
        for (score in abilityScores) {
            val ability = api.fetch<AbilityScores>(score)

            println(ability)
        }
    }
}