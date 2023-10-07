package kson

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kson.models.Traits
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class TraitsTest {
    @Test
    fun traitsGenerate() = runTest {
        val query = api.query<Traits>("")
        val result = query
        println(result)
    }

    private val list = listOf(
        "artificers-lore",
        "brave",
        "breath-weapon",
        "damage-resistance",
        "darkvision",
        "draconic-ancestry",
        "draconic-ancestry-black",
        "draconic-ancestry-blue",
        "draconic-ancestry-brass",
        "draconic-ancestry-bronze",
        "draconic-ancestry-copper",
        "draconic-ancestry-gold",
        "draconic-ancestry-green",
        "draconic-ancestry-red",
        "draconic-ancestry-silver",
        "draconic-ancestry-white",
        "dwarven-combat-training",
        "dwarven-resilience",
        "dwarven-toughness",
        "elf-weapon-training",
        "extra-language",
        "fey-ancestry",
        "gnome-cunning",
        "halfling-nimbleness",
        "hellish-resistance",
        "high-elf-cantrip",
        "infernal-legacy",
        "keen-senses",
        "lucky",
        "menacing",
        "naturally-stealthy",
        "relentless-endurance",
        "savage-attacks",
        "skill-versatility",
        "stonecunning",
        "tinker",
        "tool-proficiency",
        "trance"

    )

    @Test
    fun traitsRoute() = runTest {
        for (search in list) {
            val result = api.fetch<Traits>(search)
            println(result)
        }
    }

}