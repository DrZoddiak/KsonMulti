package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kson.models.common.Queryable
import kson.models.common.APIReference
import kson.models.common.Cost
import kson.models.common.Damage
import kson.models.common.IRef

@Serializable
data class Equipment(
    override val index: String,
    override val name: String,
    override val url: String,
    val armorCategory: String? = null,
    val armorClass: ArmorClass? = null,
    val capacity: String? = null,
    val categoryRange: String? = null,
    val contents: List<Content>? = null,
    val desc: List<String>,
    val gearCategory: APIReference? = null,
    val equipmentCategory: APIReference,
    val weaponCategory: String? = null,
    val weaponRange: String? = null,
    val cost: Cost,
    val damage: Damage? = null,
    val twoHandedDamage: Damage? = null,
    val range: Range? = null,
    val weight: Double? = null,
    val properties: List<APIReference>? = null,
    val quantity: Int? = null,
    val special: List<String>? = null,
    val speed: Speed? = null,
    val stealthDisadvantage: Boolean? = null,
    val strMinimum: Int? = null,
    val throwRange: ThrowRange? = null,
    val toolCategory: String? = null,
    val vehicleCategory: String? = null
) : IRef {
    companion object : Queryable
}

@Serializable
data class ArmorClass(
    val base: Int,
    val dexBonus: Boolean,
    val maxBonus: Int? = null
)

@Serializable
data class Content(
    val item: APIReference,
    val quantity: Int
)

@Serializable
data class ThrowRange(
    val long: Int,
    val normal: Int
)


@Serializable
data class Range(
    val long: Int? = null,
    val normal: Int
)