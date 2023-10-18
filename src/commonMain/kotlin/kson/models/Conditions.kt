package kson.models

import kotlinx.serialization.Serializable
import kson.models.common.Queryable
import kson.models.common.IRef

@Serializable
data class Conditions(
    override val index: String,
    override val name: String,
    override val url: String,
    val desc: List<String>
) : IRef {
    companion object : Queryable
}