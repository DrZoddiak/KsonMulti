package kson.models.common

interface Queryable {
    fun name(string: String) = query("name", string)
    fun query(key: String, string: String) = "$key=${string.replace(" ", "+")}"
}
