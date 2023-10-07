package kson

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kson.models.Subraces
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SubracesTest {
    @Test
    fun subracesGenerate() = runTest {
        val query = api.query<Subraces>("")
        val result = query
        println(result)
    }

    private val list = listOf(
        "high-elf",
        "hill-dwarf",
        "lightfoot-halfling",
        "rock-gnome"

    )

    @Test
    fun subracesRoute() = runTest {
        for (search in list) {
            val result = api.fetch<Subraces>(search)
            println(result)
        }
    }

}