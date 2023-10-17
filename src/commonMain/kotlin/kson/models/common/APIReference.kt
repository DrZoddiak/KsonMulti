package kson.models.common

import kotlinx.serialization.Serializable

@Serializable
data class APIReference(
    override val index: String,
    override val name: String,
    override val url: String
) : IRef
