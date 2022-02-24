package kson

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kson.models.Equipment
import kotlin.test.Test

private val api = KsonApi(client)

@OptIn(ExperimentalCoroutinesApi::class)
class EquipmentTest {

    val equipment = listOf(
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
                    $equip
                    
                    Name: ${equip.name}
                    Something : ${equip.equipment_category}
                    Damage : ${equip.damage}
                    """.trimIndent()
            )
            println("")
        }
    }
}