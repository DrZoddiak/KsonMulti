package kson

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kson.models.Subclasses
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SubclassesTest {
    @Test
    fun subclassesGenerate() = runTest {
        val query = api.query<Subclasses>("")
        val result = query.results.indexes()
        println(result)
    }

    private val list = listOf(
        "berserker",
        "champion",
        "devotion",
        "draconic",
        "evocation",
        "fiend",
        "hunter",
        "land",
        "life",
        "lore",
        "open-hand",
        "thief"

    )

    @Test
    fun subclassesRoute() = runTest {
        for (search in list) {
            val result = api.fetch<Subclasses>(search)
            println(result)
        }
    }

}