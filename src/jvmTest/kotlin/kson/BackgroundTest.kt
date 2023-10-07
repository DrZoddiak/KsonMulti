package kson

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kson.models.Backgrounds
import kotlin.test.Test

class BackgroundTest {
    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun backgroundGenerate() = runTest {
        val query = api.query<Backgrounds>("")
        println(query)
    }


    private val list = listOf(
        "acolyte"
    )

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun backgroundRoute() = runTest {
        for (search in list) {
            val result = api.fetch<Backgrounds>(search)
            println(result)
        }
    }
}