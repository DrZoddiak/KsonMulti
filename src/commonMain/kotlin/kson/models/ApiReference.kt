package kson.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject

@Serializable
data class DC(
    val dc_type: APIReference,
    val dc_value: Int? = null,
    val success_type: String? = null
)

@Serializable
data class Damage(
    val damage_type: APIReference,
    val damage_dice: String
)


@Serializable
data class Choice(
    val desc: String? = null,
    val choose: Int,
    val type: String,
    val from: OptionSet,
)


@Serializable
data class OptionSet(
    val option_set_type: String,
    val options: JsonArray? = null
)


/*
@Serializable
data class Reference(
    override val optionType: String,
    val item: DNDApiReference
) : Option
*/

interface Option {
    val optionType: String
    val item: JsonObject //TODO: type objects
    /*
        interface Action : Option {
            val actionName: String
            val count: Number
            val type: String?
        }

        interface Multiple : Option {
            val items: Array<Option>
        }

        interface Choice<T : OptionSet> {
            val choice: kson.models.Choice
        }

        interface String : Option {
            val string: kotlin.String
        }

        interface Ideal : Option {
            val desc: kotlin.String
            val alignments: Array<DNDApiReference>
        }

        interface CountedReference : Option {
            val count: Number
            val of: DNDApiReference
        }

        interface ScorePrerequisite : Option {
            val abilityScore: DNDApiReference
            val minimumScore: Number
        }

        interface AbilityBonus : Option {
            val abilityScore: DNDApiReference
            val bonus: Number
        }

        interface Breath : Option {
            val name: kotlin.String
            val dc: DC
            val damage: Damage
        }

        interface Damage : Option {
            val damageType: DNDApiReference
            val damageDice: kotlin.String
            val notes: kotlin.String
        }*/
}
