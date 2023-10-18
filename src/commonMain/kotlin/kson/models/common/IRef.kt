package kson.models.common

interface IRef : Queryable {
    val name: String
    val index: String
    val url: String
}