package kson.models.common

/**
 * This represents an object that can be queried with the api
 */
interface Queryable {
    fun name(string: String) = query("name", string)
    fun query(key: String, string: String) = "$key=${string.replace(" ", "+")}"
}
