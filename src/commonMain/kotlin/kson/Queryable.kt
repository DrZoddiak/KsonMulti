package kson

interface Queryable {
    object Monsters : Queryable {
        fun challengeRating(vararg double: Double) = double.sortContent("challenge_rating")
    }

    object Spells : Queryable {
        fun level(vararg int: Int) = int.sortContent("level")
        fun school(vararg string: String) = string.sortContent("school")
    }

    object Feats : Queryable {
        fun name(vararg string: String) = string.sortContent("name")
    }

    fun Array<out String>.sortContent(prefix: String) = "$prefix=${joinToString()}"
    fun IntArray.sortContent(prefix: String) = "$prefix=${joinToString()}"
    fun DoubleArray.sortContent(prefix: String) = "$prefix=${joinToString()}"
}
