package kson

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kson.models.Languages
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class LanguagesTest {
    @Test
    fun languagesGenerate() = runTest {
        val query = api.query<Languages>("")
        val result = query.results.indexes()
        println(result)
    }

    private val list = listOf(
        "abyssal",
        "celestial",
        "common",
        "deep-speech",
        "draconic",
        "dwarvish",
        "elvish",
        "giant",
        "gnomish",
        "goblin",
        "halfling",
        "infernal",
        "orc",
        "primordial",
        "sylvan",
        "undercommon"
    )

    @Test
    fun languagesRoute() = runTest {
        for (search in list) {
            val result = api.fetch<Languages>(search)
            println(result)
        }
    }

}