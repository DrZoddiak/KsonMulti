package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("")
data class DefaultRequest(
    var count: Int,
    var results: List<APIReference>
)

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
        //Shamelessly stolen (and modified) from JsonObject.
        return map.entries.joinToString(
            separator = ",",
            prefix = "{",
            postfix = "}",
            transform = { (k, v) ->
                buildString {
                    append("\"$k\"")
                    append(':')
                    append("\"$v\"")
                }
            }
        )
    }
}

fun List<APIReference>.names() = this.joinToString(",") { it.name }

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