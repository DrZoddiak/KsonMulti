package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject

interface IRef {
    val name: String
    val index: String
    val url: String
}

@Serializable
data class DC(
    @SerialName("dc_type")
    val dcType: APIReference,
    @SerialName("dc_value")
    val dcValue: Int? = null,
    @SerialName("success_type")
    val successType: String? = null
)

@Serializable
data class Damage(
    @SerialName("damage_type")
    val damageType: APIReference,
    @SerialName("damage_dice")
    val damageDice: String
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
    @SerialName("option_set_type")
    val optionSetType: String,
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
