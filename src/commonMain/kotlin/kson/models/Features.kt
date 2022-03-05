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
    val subclass: APIReference,
    val desc: List<String>,
    val feature_specific: FeatureSpecific,
    override val url: String
) : DefaultTrait {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}

@Serializable
data class FeatureSpecific(
    val subfeature_options: Choice,
    val expertise_options: Choice
) {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}