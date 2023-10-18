package kson

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kson.models.Classes
import kson.models.Monsters
import kson.models.Spells
import kson.models.common.Queryable
import kotlin.test.Test
import kotlin.test.assertEquals

class QueryTest {
    val api get() = KsonApi(client)

    @OptIn(ExperimentalCoroutinesApi::class)
    inline fun <reified T : Queryable> testQuery(string: String, count: Int) = runTest {
        val ret = api.query<T>(string)
        println("Received: $count")
        assertEquals(count, ret.count, "Expected: $count, Actual: ${ret.count}")
    }

    @Test
    fun monsterCRTest() = testQuery<Monsters>(Monsters.challengeRating(2.0), 43)

    @Test
    fun monsterMultiCRTest() = testQuery<Monsters>(Monsters.challengeRating(2.0, 3.0, 4.0), 80)

    @Test
    fun monsterNameTestDragon() = testQuery<Monsters>(Monsters.name("dragon"), 43)

    @Test
    fun monsterNameTestDog() = testQuery<Monsters>(Monsters.name("dog"), 2)

    @Test
    fun monsterPartialNameTest() = testQuery<Monsters>(Monsters.name("e"), 212)

    @Test
    fun spellLevel2Test() = testQuery<Spells>(Spells.level(2), 54)

    @Test
    fun spellLevel4Test() = testQuery<Spells>(Spells.level(4), 31)

    @Test
    fun spellNameTest() = testQuery<Spells>(Spells.name("acid"), 2)

    @Test
    fun spellNameWithSpaceTest() = testQuery<Spells>(Spells.name("acid arrow"), 1)

    @Test
    fun spellSchoolTest() = testQuery<Spells>(Spells.school("evocation"), 60)

    @Test
    fun classesNameTest() = testQuery<Classes>(Classes.name("bar"), 2)

}