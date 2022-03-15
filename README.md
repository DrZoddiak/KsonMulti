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
