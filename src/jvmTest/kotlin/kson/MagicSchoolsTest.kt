package kson

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kson.models.MagicSchools
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MagicSchoolsTest {
    @Test
    fun magicSchoolsGenerate() = runTest {
        val query = api.query<MagicSchools>("")
        val result = query.results.indexes()
        println(result)
    }

    private val list = listOf(
        "abjuration",
        "conjuration",
        "divination",
        "enchantment",
        "evocation",
        "illusion",
        "necromancy",
        "transmutation"

    )

    @Test
    fun magicSchoolsRoute() = runTest {
        for (search in list) {
            val result = api.fetch<MagicSchools>(search)
            println(result)
        }
    }

}