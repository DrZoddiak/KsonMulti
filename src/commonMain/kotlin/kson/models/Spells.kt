package kson.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
class Spells(
    override val index: String,
    override val name: String,
    val desc: List<String>,
    val higher_level: List<String>? = null,
    val range: String,
    val components: List<String>,
    val material: String,
    val ritual: Boolean,
    val duration: String,
    val concentration: Boolean,
    val casting_time: String,
    val level: Int,
    val attack_type : String? = null,
    val damage : JsonObject? = null,
    val school: APIReference,
    val classes: List<APIReference>,
    val subclasses: List<APIReference>,
    override val url: String
) : DefaultTrait

