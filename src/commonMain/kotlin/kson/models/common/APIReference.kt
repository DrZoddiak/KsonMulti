package kson.models.common

import kotlinx.serialization.Serializable

/**
 * This is the concrete type of [IRef]
 */
@Serializable
data class APIReference(
    override val index: String,
    override val name: String,
    override val url: String
) : IRef
