package kson

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kson.models.DamageTypes
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class DamageTypeTest {
    @Test
    fun damageTypeGenerate() = runTest {
        val query = api.query<DamageTypes>("")
        val result = query
        println(result)
    }

    private val list = listOf(
        "acid",
        "bludgeoning",
        "cold",
        "fire",
        "force",
        "lightning",
        "necrotic",
        "piercing",
        "poison",
        "psychic",
        "radiant",
        "slashing",
        "thunder"
    )

    @Test
    fun damageTypeRoute() = runTest {
        for (search in list) {
            val result = api.fetch<DamageTypes>(search)
            println(result)
        }
    }

}