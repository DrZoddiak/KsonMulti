package kson

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kson.models.Conditions
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ConditionsTest {
    @Test
    fun conditionsGenerate() = runTest {
        val query = api.query<Conditions>("")
        val result = query.results.indexes()
        println(result)
    }

    private val list = listOf(
        "blinded",
        "charmed",
        "deafened",
        "exhaustion",
        "frightened",
        "grappled",
        "incapacitated",
        "invisible",
        "paralyzed",
        "petrified",
        "poisoned",
        "prone",
        "restrained",
        "stunned",
        "unconscious"

    )

    @Test
    fun conditionsRoute() = runTest {
        for (search in list) {
            val result = api.fetch<Conditions>(search)
            println(result)
        }
    }

}