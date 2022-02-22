package kson.routes

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
class Spells(
    override val index: String?,
    override val name: String?,
    val desc: List<String?>?,
    val higher_level: List<APIReference?>?,
    val range: String?,
    val components: List<APIReference?>?,
    val material: String?,
    val ritual: Boolean?,
    val duration: String?,
    val concentration: Boolean?,
    val casting_time: String?,
    val level: Int?,
    val attack_type : String?,
    val damage : JsonObject?,
    val school: APIReference?,
    val classes: APIReference?,
    val subclasses: List<APIReference?>?,
    override val url: String?
) : DefaultTrait

