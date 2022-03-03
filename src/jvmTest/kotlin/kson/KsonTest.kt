package kson

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kson.models.Monsters
import kson.models.AbilityScores
import kotlin.test.Test
import kotlin.test.assertFails

private val api = KsonApi(client)

@OptIn(ExperimentalCoroutinesApi::class)
class MonsterTests {
    private val monsters = listOf(
        "goBlin",
        "aColYte",
        "aZer",
        "werewolf-human",
        "brass-draGon-wyrmling"
    )

    @Test
    fun monsterRoute() = runTest {
        for (monster in monsters) {

            val mon = api.fetch<Monsters>(monster)
            println("""
                Name: ${mon.name}
                CR: ${mon.challenge_rating}
                Form: ${mon.forms?.names()}
                Attack : ${mon.actions?.names()}
            """.trimIndent()
            )
        }
        println(api.query<Monsters>(""))
    }

    @Test
    fun monsterCRTest() = runTest {
        val mon = api.query<Monsters>(Queryable.Monsters.challengeRating(0.25,1.0))
        val results = mon.results.names().replace(",","\n")
        println(mon.count)
        println(results)
    }
}

class AbilityScoreTests {
    private val abilityScores = listOf(
        "cha",
        "con",
        "dex",
        "int",
        "str",
        "wis"
    )

    @Test
    fun abilityScoresRoute() = runTest {
        for (score in abilityScores) {
            val ability = api.fetch<AbilityScores>(score)

            val name = ability.full_name
            val skills = ability.skills
            println(
                """
                Name : $name
                Skills : ${skills.names()}
            """.trimIndent()
            )
        }
    }
}

class FailingTests {
    @Test
    fun monsterRoute() = runTest {
        println("FAIL TESTS")
        assertFails("Creature should never exist!") {
            api.fetch<Monsters>("A creature that does not exist")
        }
    }

}
