package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kson.models.common.Queryable
import kson.models.common.APIReference
import kson.models.common.IRef

@Serializable
data class Spells(
    override val index: String,
    override val name: String,
    override val url: String,
    val desc: List<String>,
    val higherLevel: List<String>? = null,
    val range: String,
    val components: List<String>,
    val material: String? = null,
    val areaOfEffect: AreaOfEffect? = null,
    val ritual: Boolean,
    val duration: String,
    val concentration: Boolean,
    val castingTime: String,
    val level: Int,
    val attackType: String? = null,
    val damage: DamageContent? = null,
    val dc: SpellDC? = null,
    val school: APIReference,
    val classes: List<APIReference>,
    val subclasses: List<APIReference>,
    val healAtSlotLevel: SlotLevel? = null,
) : IRef {
    companion object : Queryable {
        fun level(int: Int) = query("level", int.toString())
        fun school(string: String) = query("school", string)
    }
}

@Serializable
data class SpellDC(
    val dcType: APIReference,
    val dcSuccess: String,
    val desc: String? = null,
)

@Serializable
data class DamageContent(
    val damageAtSlotLevel: SlotLevel? = null,
    val damageAtCharacterLevel: SlotLevel? = null,
    val damageType: APIReference? = null
)

@Serializable
data class SlotLevel(
    //Name is numerical, but kotlin doesn't support numerical names.
    @SerialName("1")
    val one: String? = null,
    @SerialName("2")
    val two: String? = null,
    @SerialName("3")
    val three: String? = null,
    @SerialName("4")
    val four: String? = null,
    @SerialName("5")
    val five: String? = null,
    @SerialName("6")
    val six: String? = null,
    @SerialName("7")
    val seven: String? = null,
    @SerialName("8")
    val eight: String? = null,
    @SerialName("9")
    val nine: String? = null,
    @SerialName("11")
    val eleven: String? = null,
    @SerialName("17")
    val seventeen: String? = null,
)

@Serializable
data class AreaOfEffect(
    val size: Int,
    val type: String
)


