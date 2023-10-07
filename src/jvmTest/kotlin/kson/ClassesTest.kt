package kson

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kson.models.Classes
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ClassesTest {
    @Test
    fun classesGenerate() = runTest {
        val query = api.query<Classes>("")
        println(query)
    }

    private val list = listOf(
        "barbarian",
        "bard",
        "cleric",
        "druid",
        "fighter",
        "monk",
        "paladin",
        "ranger",
        "rogue",
        "sorcerer",
        "warlock",
        "wizard"
    )

    @Test
    fun classesRoute() = runTest {
        for (search in list) {
            val result = api.fetch<Classes>(search)
            println(result)
        }
    }

}