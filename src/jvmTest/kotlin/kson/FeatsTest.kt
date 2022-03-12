package kson

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kson.models.Feats
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FeatsTest {
    @Test
    fun featsGenerate() = runTest {
        val query = api.query<Feats>("")
        val result = query.results.indexes()
        println(result)
    }

    private val list = listOf(
        "grappler"
    )

    @Test
    fun featsRoute() = runTest {
        for (search in list) {
            val result = api.fetch<Feats>(search)
            println(result)
        }
    }

}