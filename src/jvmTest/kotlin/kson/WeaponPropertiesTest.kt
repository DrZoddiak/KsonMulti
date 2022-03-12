package kson

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kson.models.WeaponProperties
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class WeaponPropertiesTest {
    @Test
    fun weaponPropertiesGenerate() = runTest {
        val query = api.query<WeaponProperties>("")
        val result = query.results.indexes()
        println(result)
    }

    private val list = listOf(
        "ammunition",
        "finesse",
        "heavy",
        "light",
        "loading",
        "monk",
        "reach",
        "special",
        "thrown",
        "two-handed",
        "versatile"

    )

    @Test
    fun weaponPropertiesRoute() = runTest {
        for (search in list) {
            val result = api.fetch<WeaponProperties>(search)
            println(result)
        }
    }

}