package kson.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class DefaultRequest(
    var count: Int,
    var results: List<APIReference>
) {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

@Serializable
class APIReference(
    override val index: String,
    override val name: String,
    override val url: String
) : DefaultTrait {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

@Serializable
data class Choice(
    val choose: Int,
    val type: String,
    val from: List<APIReference>
) {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

@Serializable
data class Cost(
    val quantity: Int,
    val unit: String
) {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

//Interfaces

interface DefaultTrait : Nameable, Indexable {
    override val index: String
    override val name: String
    val url: String
}

interface Options {
    val choose: String
    val type: String
    val from: Collection<*>
}

interface GameMechanics : DefaultTrait {
    override val index: String
    override val name: String
    val desc: String
    override val url: String
}

interface Nameable {
    val name: String
}

interface Indexable {
    val index: String
}