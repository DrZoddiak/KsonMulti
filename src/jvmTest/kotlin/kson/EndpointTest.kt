@file:OptIn(ExperimentalCoroutinesApi::class)

package kson

import io.ktor.serialization.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kson.models.AbilityScores
import kson.models.Alignments
import kson.models.Backgrounds
import kson.models.Classes
import kson.models.Conditions
import kson.models.DamageTypes
import kson.models.Equipment
import kson.models.EquipmentCategories
import kson.models.Feats
import kson.models.Features
import kson.models.common.IRef
import kson.models.Languages
import kson.models.MagicItems
import kson.models.MagicSchools
import kson.models.Monsters
import kson.models.Proficiencies
import kson.models.Races
import kson.models.RuleSections
import kson.models.Rules
import kson.models.Skills
import kson.models.Spells
import kson.models.Subclasses
import kson.models.Subraces
import kson.models.Traits
import kson.models.WeaponProperties
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

class EndpointTest {

    private val api get() = KsonApi(client)

    private lateinit var generatedList: List<String>

    private inline fun <reified T : IRef> generateList() = runTest {
        generatedList = api.query<T>().results.map { it.index }
    }

    private inline fun <reified T : IRef> testEndpoint() = runTest {
        generateList<T>()
        generatedList.map {
            val ret = api.fetch<T>(it)
            println(Json.encodeToString(ret))
            ret.index
        }
            .zip(generatedList)
            .map { assertEquals(it.first, it.second, "${it.first} == ${it.second}") }
    }

    @Test
    fun abilityScoreEndpoint() = testEndpoint<AbilityScores>()

    @Test
    fun alignmentEndpoint() = testEndpoint<Alignments>()

    @Test
    fun backgroundEndpoint() = testEndpoint<Backgrounds>()

    @Test
    fun classesEndpoint() = testEndpoint<Classes>()

    @Test
    fun conditionsEndpoint() = testEndpoint<Conditions>()

    @Test
    fun damageTypesEndpoint() = testEndpoint<DamageTypes>()

    @Test
    fun equipmentEndpoint() = testEndpoint<Equipment>()

    @Test
    fun equipmentCategoryEndpoint() = testEndpoint<EquipmentCategories>()

    @Test
    fun featsEndpoint() = testEndpoint<Feats>()

    @Test
    fun featuresEndpoint() = testEndpoint<Features>()

    @Test
    fun languagesEndpoint() = testEndpoint<Languages>()

    @Test
    fun magicItemsEndpoint() = testEndpoint<MagicItems>()

    @Test
    fun magicSchoolsEndpoint() = testEndpoint<MagicSchools>()

    @Test
    fun monstersEndpoint() = testEndpoint<Monsters>()

    @Test
    fun proficienciesEndpoint() = testEndpoint<Proficiencies>()

    @Test
    fun racesEndpoint() = testEndpoint<Races>()

    @Test
    fun rulesEndpoint() = testEndpoint<Rules>()

    @Test
    fun ruleSectionEndpoint() = testEndpoint<RuleSections>()

    @Test
    fun skillsEndpoint() = testEndpoint<Skills>()

    @Test
    fun spellsEndpoint() = testEndpoint<Spells>()

    @Test
    fun subclassesEndpoint() = testEndpoint<Subclasses>()

    @Test
    fun subracesEndpoint() = testEndpoint<Subraces>()

    @Test
    fun traitsEndpoint() = testEndpoint<Traits>()

    @Test
    fun weaponPropertiesEndpoint() = testEndpoint<WeaponProperties>()

    @Test
    fun failingEndpoint() {
        assertThrows<JsonConvertException> {
            runTest {
                api.fetch<AbilityScores>("Luck")
            }
        }
    }
}