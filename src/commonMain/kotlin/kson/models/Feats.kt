package kson.models

import kotlinx.serialization.Serializable
import kson.models.common.Queryable
import kson.models.common.APIReference
import kson.models.common.IRef

@Serializable
data class Feats(
    override val index: String,
    override val name: String,
    override val url: String,
    val prerequisites: List<Prerequisite>,
    val desc: List<String>
) : IRef {
    companion object : Queryable
}

@Serializable
data class Prerequisite(
    val abilityScore: APIReference,
    val minimumScore: Int
)
