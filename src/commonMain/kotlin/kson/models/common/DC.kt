package kson.models.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DC(
    @SerialName("dc_type")
    val dcType: APIReference,
    @SerialName("dc_value")
    val dcValue: Int? = null,
    @SerialName("success_type")
    val successType: String? = null
)