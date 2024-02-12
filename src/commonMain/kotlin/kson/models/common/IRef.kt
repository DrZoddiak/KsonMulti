package kson.models.common

/**
 * Represents an [API Reference](https://5e-bits.github.io/docs/docs/reference/schemas#api-reference)
 */
interface IRef : Queryable {
    val name: String
    val index: String
    val url: String
}