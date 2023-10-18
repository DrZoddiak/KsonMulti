package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kson.models.common.Queryable
import kson.models.common.APIReference
import kson.models.common.Choice
import kson.models.common.IRef

@Serializable
data class Features(
    override val index: String,
    override val name: String,
    override val url: String,
    val desc: List<String>,
    val level: Int,
    @SerialName("class") //Reserved word.
    val clazz: APIReference,
    val subclass: APIReference? = null,
    val parent: APIReference? = null,
    val prerequisites: List<PrerequisiteFeature>? = null,
    val featureSpecific: FeatureSpecific? = null,
    val reference: String? = null
) : IRef {
    companion object : Queryable
}

@Serializable
data class FeatureSpecific(
    val subfeatureOptions: Choice? = null,
    val expertiseOptions: Choice? = null,
    val invocations: List<APIReference>? = null
)

@Serializable
data class PrerequisiteFeature(
    val level: Int? = null,
    val type: String,
    val spell: String? = null,
    val feature: String? = null,
)