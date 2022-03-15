package kson

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kson.models.EquipmentCategories
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class EquipmentCategoriesTest {
    @Test
    fun equipmentCategoryGenerate() = runTest {
        val query = api.query<EquipmentCategories>("")
        val result = query.results.indexes()
        println(result)
    }

    private val list = listOf(
        "adventuring-gear",
        "ammunition",
        "arcane-foci",
        "armor",
        "artisans-tools",
        "druidic-foci",
        "equipment-packs",
        "gaming-sets",
        "heavy-armor",
        "holy-symbols",
        "kits",
        "land-vehicles",
        "light-armor",
        "martial-melee-weapons",
        "martial-ranged-weapons",
        "martial-weapons",
        "medium-armor",
        "melee-weapons",
        "mounts-and-other-animals",
        "mounts-and-vehicles",
        "musical-instruments",
        "other-tools",
        "potion",
        "ranged-weapons",
        "ring",
        "rod",
        "scroll",
        "shields",
        "simple-melee-weapons",
        "simple-ranged-weapons",
        "simple-weapons",
        "staff",
        "standard-gear",
        "tack-harness-and-drawn-vehicles",
        "tools",
        "wand",
        "waterborne-vehicles",
        "weapon",
        "wondrous-items"
    )

    @Test
    fun equipmentCategoryRoute() = runTest {
        for (search in list) {
            val result = api.fetch<EquipmentCategories>(search)
            println(result)
        }
    }

}