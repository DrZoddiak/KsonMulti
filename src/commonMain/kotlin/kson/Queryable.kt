package kson

class Queryable {
    object Monsters {
        fun challengeRating(vararg double: Double) = double.sortContent("challenge_rating")
    }

    object Spells {
        fun level(vararg int: Int) = int.sortContent("level")
        fun school(vararg string: String) = string.sortContent("school")
    }

    object Feats {
        fun name(vararg string: String) = string.sortContent("name")
    }
}

//In-case I require these for the future.
fun Array<out String>.sortContent(prefix: String) = "$prefix=${this.joinToString(",")}"
fun IntArray.sortContent(prefix: String) = "$prefix=${this.joinToString(",")}"
fun DoubleArray.sortContent(prefix: String) = "$prefix=${this.joinToString(",")}"

