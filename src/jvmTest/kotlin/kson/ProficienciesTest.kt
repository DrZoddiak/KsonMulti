package kson

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kson.models.Proficiencies
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ProficienciesTest {
    @Test
    fun proficenciesGenerate() = runTest {
        val query = api.query<Proficiencies>("")
        val result = query
        println(result)
    }

    private val list = listOf(
        "alchemists-supplies",
        "all-armor",
        "bagpipes",
        "battleaxes",
        "blowguns",
        "breastplate",
        "brewers-supplies",
        "calligraphers-supplies",
        "carpenters-tools",
        "cartographers-tools",
        "chain-mail",
        "chain-shirt",
        "clubs",
        "cobblers-tools",
        "cooks-utensils",
        "crossbows-heavy",
        "crossbows-light",
        "daggers",
        "darts",
        "dice-set",
        "disguise-kit",
        "drum",
        "dulcimer",
        "flails",
        "flute",
        "forgery-kit",
        "glaives",
        "glassblowers-tools",
        "greataxes",
        "greatclubs",
        "greatswords",
        "halberds",
        "half-plate-armor",
        "hand-crossbows",
        "handaxes",
        "heavy-armor",
        "herbalism-kit",
        "hide-armor",
        "horn",
        "javelins",
        "jewelers-tools",
        "lances",
        "land-vehicles",
        "leather-armor",
        "leatherworkers-tools",
        "light-armor",
        "light-hammers",
        "longbows",
        "longswords",
        "lute",
        "lyre",
        "maces",
        "martial-weapons",
        "masons-tools",
        "mauls",
        "medium-armor",
        "morningstars",
        "navigators-tools",
        "nets",
        "padded-armor",
        "painters-supplies",
        "pan-flute",
        "pikes",
        "plate-armor",
        "playing-card-set",
        "poisoners-kit",
        "potters-tools",
        "quarterstaffs",
        "rapiers",
        "ring-mail",
        "saving-throw-cha",
        "saving-throw-con",
        "saving-throw-dex",
        "saving-throw-int",
        "saving-throw-str",
        "saving-throw-wis",
        "scale-mail",
        "scimitars",
        "shawm",
        "shields",
        "shortbows",
        "shortswords",
        "sickles",
        "simple-weapons",
        "skill-acrobatics",
        "skill-animal-handling",
        "skill-arcana",
        "skill-athletics",
        "skill-deception",
        "skill-history",
        "skill-insight",
        "skill-intimidation",
        "skill-investigation",
        "skill-medicine",
        "skill-nature",
        "skill-perception",
        "skill-performance",
        "skill-persuasion",
        "skill-religion",
        "skill-sleight-of-hand",
        "skill-stealth",
        "skill-survival",
        "slings",
        "smiths-tools",
        "spears",
        "splint-armor",
        "studded-leather-armor",
        "thieves-tools",
        "tinkers-tools",
        "tridents",
        "viol",
        "war-picks",
        "warhammers",
        "water-vehicles",
        "weavers-tools",
        "whips",
        "woodcarvers-tools"

    )

    @Test
    fun proficenciesRoute() = runTest {
        for (search in list) {
            val result = api.fetch<Proficiencies>(search)
            println(result)
        }
    }

}