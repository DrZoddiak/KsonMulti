package kson

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kson.models.Races
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RaceTest {
    @Test
    fun raceGenerate() = runTest {
        val query = api.query<Races>("")
        val result = query
        println(result)
    }

    private val list = listOf(
        "dragonborn",
        "dwarf",
        "elf",
        "gnome",
        "half-elf",
        "half-orc",
        "halfling",
        "human",
        "tiefling"

    )

    @Test
    fun raceRoute() = runTest {
        for (search in list) {
            val result = api.fetch<Races>(search)
            println(result)
        }
    }

}