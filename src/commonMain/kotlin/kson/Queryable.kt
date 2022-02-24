package kson

class Queryable {
    object Monsters {
        fun challengeRating(vararg double: Double) = "challenge_rating=${double.joinToString(",")}"
    }

    object Spells {
        fun level(vararg int: Int) = "level=${int.joinToString(",")}"
        fun school(vararg string: String) = "school=${string.joinToString(",")}"
    }

    object Feats {
        fun name(vararg string: String) = "name=${string.joinToString(",")}"
    }
}