package kson

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kson.models.Spells
import kotlin.test.Test

private val api = KsonApi(client)

@OptIn(ExperimentalCoroutinesApi::class)
class SpellTest {

    val equipment = listOf(
        "acid-arrow",
        "augury",
        "ice-storm",
        "identify"
    )

    @Test
    fun spellTest() = runTest {
        for (item in equipment) {
            val equip = api.fetch<Spells>(item)
            println(
                """
                    $equip
                    
                    Name: ${equip.name}
                    Something : ${equip.components}
                    Damage : ${equip.damage}
                    """.trimIndent()
            )
            println("")
        }
    }

    @Test
    fun spellQueryTest() = runTest {
        val equip = api.query<Spells>(Queryable.Spells.school("evo","ill"))
        val results = equip.results.names().replace(",","\n")
        println(equip.count)
        println(results)
    }
}
