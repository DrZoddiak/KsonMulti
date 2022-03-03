package kson

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kson.models.Equipment
import kson.models.Monsters
import kotlin.test.Test



@OptIn(ExperimentalCoroutinesApi::class)
class EquipmentTest {
    private val api = KsonApi(client)

    private val equipment = listOf(
        "blowgun",
        "javelin",
        "longsword",
    )

    @Test
    fun equipmentTest() = runTest {
        for (item in equipment) {
            val equip = api.fetch<Equipment.Weapons>(item)
            println(
                """
                    
                    Name: ${equip.name}
                    Something : ${equip.equipment_category}
                    Damage : ${equip.damage}
                    """.trimIndent()
            )
            println("")
        }
    }
}