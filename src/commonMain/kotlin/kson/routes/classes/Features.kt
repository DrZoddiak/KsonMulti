package kson.routes.classes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kson.routes.APIReference
import kson.routes.Choice
import kson.routes.DefaultTrait

@Serializable
data class Features(
    val index: String?,
    val name: String?,
    val level: Int?,
    @SerialName("class") //Reserved word.
    val clazz: APIReference,
    val subclass: APIReference,
    val desc: List<String?>?,
    val feature_specific: FeatureSpecific?,
    val url: String?
)

@Serializable
data class FeatureSpecific(
    val subfeature_options: Choice?,
    val expertise_options: Choice?
)