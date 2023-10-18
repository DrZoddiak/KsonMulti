package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kson.models.common.Queryable
import kson.models.common.APIReference
import kson.models.common.IRef

@Serializable
data class Skills(
    override val index: String,
    override val name: String,
    override val url: String,
    val desc: List<String>,
    val abilityScore: APIReference
) : IRef {
    companion object : Queryable
}
