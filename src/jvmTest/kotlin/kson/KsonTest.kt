package kson

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import kson.Monsters.fetch
import kson.routes.Routes
import kotlin.coroutines.CoroutineContext
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class KsonTest {

    private val monsters = listOf(
        "goblin",
        "acolyte",
        "azer",
        "werewolf-human",
        "brass-dragon-wyrmling",
    )


    @Test
    fun monsterRoute() = runTest {
        for (monster in monsters) {
            val mon = Monsters.fetch(monster)
            println(
                """
                Name: ${mon.name}
            """.trimIndent()
            )
        }
    }

    @Test
    fun abilityScoresRoute() = runTest {
        val score = CharacterData.AbilityScores.fetch("cha")

        println("""
            ${score.full_name}
        """.trimIndent())
    }

}