package kson.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Features(
    override val index: String,
    override val name: String,
    val level: Int,
    @SerialName("class") //Reserved word.
    val clazz: APIReference,
    val subclass: APIReference? = null,
    val desc: List<String>,
    val feature_specific: FeatureSpecific? = null,
    val parent: APIReference? = null,
    val reference: String? = null,
    val prerequisite: List<PrerequisiteFeature>? = null,
    override val url: String
) : DefaultTrait {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

@Serializable
data class FeatureSpecific(
    val subfeature_options: FeatureChoice? = null,
    val expertise_options: FeatureChoice? = null
) {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

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