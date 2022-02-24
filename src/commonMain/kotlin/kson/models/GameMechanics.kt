package kson.models

import kson.DefaultTrait

interface GameMechanics : DefaultTrait {
    override val index: String
    override val name: String
    val desc: List<String>
    override val url: String
}