package kson

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kson.models.Alignments
import kotlin.test.Test

class AlignmentTest {
    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun alignmentGenerate() = runTest {
        val align = api.query<Alignments>("")
        println(align)

    }


    private val alignments = listOf(
        "chaotic-evil",
        "chaotic-good",
        "chaotic-neutral",
        "lawful-evil",
        "lawful-good",
        "lawful-neutral",
        "neutral",
        "neutral-evil",
        "neutral-good"
    )

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun alignmentRoute() = runTest {
        for (alignment in alignments) {
            val align = api.fetch<Alignments>(alignment)

            println(align)
        }
    }
}