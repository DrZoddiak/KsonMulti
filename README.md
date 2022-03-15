# KsonMulti - D&D 5e API Wrapper

KsonMulti is a Kotlin Multiplatform Project that targets JS/JVM.

This is a wrapper for [D&D 5e SRD API](https://www.dnd5eapi.co/)

# Installation

### Kotlin/JS:

```kts
repositories {
    maven("https://repo.zodd.me/releases")
}

dependencies {
    implementation("me.zodd:KsonMulti-js:$version")
}

```

### Kotlin/JVM

```kts
repositories {
    maven("https://repo.zodd.me/releases")
}

dependencies {
    implementation("me.zodd:KsonMulti-jvm:$version")
}

```

# Getting Started

Import wrapper and assign default client.

```kt
import kson.KsonApi
import kson.client

private val api = KsonApi(client)
```

Use alternate route

```kt
private val api = KsonApi(client, "http://localhost:8080")
```

Retrieving data

```kt
import kson.models.Monsters
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

val scope = CoroutineScope(Dispatchers.Default)

scope.launch {
    val monster = api.fetch<Monsters>("Goblin")
    
    println(
        """
            ${monster.name}
            ${monster.languages}
        """.trimIndent()
    )
}
```

```kt
import kson.models.Monsters
import kson.models.Spells
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

val scope = CoroutineScope(Dispatchers.Default)

scope.launch {
    //Use Queryable for preset options that use varargs!
    //Returns a comma separated list of matched content.
    val monster = api.query<Monsters>(Queryable.Monsters.challengeRating(2.0,1.5,3.0))
    
    //Or query nothing for default return
    val spell = api.query<Spells>()
    
    println(spell)
}
```

### Example Output

Displayed in the order presented above.

[Goblin](https://gist.github.com/DrZoddiak/0f48ccdbea0c1ddc6b5106be2ee9c273)

[Goblin Types](https://gist.github.com/DrZoddiak/ad98918b80ab49291ce70736789a6814)

[Monster Query](https://gist.github.com/DrZoddiak/e82f2977558013a053364f6a8ec324ba)

[Spell Empty Query](https://gist.github.com/DrZoddiak/eb61fc996758c6bba030c83184529cc7)