package kson

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kson.models.Skills
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SkillsTest {
    @Test
    fun skillsGenerate() = runTest {
        val query = api.query<Skills>("")
        val result = query
        println(result)
    }

    private val list = listOf(
        "acrobatics",
        "animal-handling",
        "arcana",
        "athletics",
        "deception",
        "history",
        "insight",
        "intimidation",
        "investigation",
        "medicine",
        "nature",
        "perception",
        "performance",
        "persuasion",
        "religion",
        "sleight-of-hand",
        "stealth",
        "survival"
    )

    @Test
    fun skillsRoute() = runTest {
        for (search in list) {
            val result = api.fetch<Skills>(search)
            println(result)
        }
    }

}