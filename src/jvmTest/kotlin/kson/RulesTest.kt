package kson

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kson.models.Rules
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RulesTest {
    @Test
    fun rulesGenerate() = runTest {
        val query = api.query<Rules>("")
        val result = query.results.indexes()
        println(result)
    }

    private val list = listOf(
        "adventuring",
        "appendix",
        "combat",
        "equipment",
        "spellcasting",
        "using-ability-scores"

    )

    @Test
    fun rulesRoute() = runTest {
        for (search in list) {
            val result = api.fetch<Rules>(search)
            println(result)
        }
    }

}