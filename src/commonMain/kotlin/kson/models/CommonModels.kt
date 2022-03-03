package kson.models

import kotlinx.serialization.Serializable

@Serializable
data class DefaultRequest(
    var count: Int,
    var results: List<APIReference>
) {
    override fun toString(): String {
        val map = mapOf(
            Pair("count", count),
            Pair("results", results)
        )
        return map.joinEntries()
    }
}

@Serializable
class APIReference(
    override val index: String,
    override val name: String,
    override val url: String
) : DefaultTrait {
    override fun toString(): String {
        val map = mapOf(
            Pair("index", index),
            Pair("name", name),
            Pair("url", url)
        )
        return map.joinEntries()
    }
}

@Serializable
data class Choice(
    val choose: Int,
    val type: String,
    val from: List<APIReference>
)

@Serializable
data class Cost(
    val quantity: Int,
    val unit: String
)

//Interfaces

interface DefaultTrait {
    val index: String
    val name: String
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
    val desc: List<String>
    override val url: String
}

//Extension Functions
fun List<APIReference>.names() = this.joinToString(",") { it.name }

fun Map<String, Any?>.joinEntries() = this.entries.joinToString(
    ",",
    "{",
    "}",
    transform = { (k, v) ->
        buildString {
            append("\"$k\"")
            append(':')
            append("\"$v\"")
        }
    }
)
