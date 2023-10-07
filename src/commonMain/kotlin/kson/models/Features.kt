package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.Serial

@Serializable
data class Features(
    override val index: String,
    override val name: String,
    val level: Int,
    @SerialName("class") //Reserved word.
    val clazz: APIReference,
    val subclass: APIReference? = null,
    val desc: List<String>,
    //val feature_specific: FeatureSpecific? = null, TODO uncomment
    override val url: String,
    val parent: APIReference? = null,
    val reference: String? = null,
    val prerequisite: List<PrerequisiteFeature>? = null
) : IRef

@Serializable
data class FeatureSpecific(
    @SerialName("subfeature_options")
    val subfeatureOptions: FeatureChoice? = null,
    @SerialName("expertise_options")
    val expertiseOptions: FeatureChoice? = null
)

@Serializable
data class FeatureChoice(
    val choose: String? = null,
    val from: List<APIReference>,
    val type: String? = null
)

@Serializable
@SerialName("Prerequisite")
data class PrerequisiteFeature(
    val level: Int,
    val type: String
)