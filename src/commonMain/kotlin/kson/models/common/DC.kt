package kson.models.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DC(
    val dcType: APIReference,
    val dcValue: Int? = null,
    val successType: String? = null
)