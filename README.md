# KsonMulti

How to add to your environment:

# Kotlin/JS: 

```kts
repositories {
    maven("https://repo.zodd.me/releases")
}

dependencies {
    implementation("me.zodd:KsonMulti-js:$version")
}

```
# JVM
```kts
repositories {
    maven("https://repo.zodd.me/releases")
}

dependencies {
    implementation("me.zodd:KsonMulti-jvm:$version")
}

```

# Usage

```kt
import kson.KsonApi
import kson.client

class EquipmentTest {
    
    //a default client is provided, but can be passed in.
    //Default URL can also be changed by passing in a string to the constructor.
    private val api = KsonApi(client)
    
    //Fetch requests are made with Strings for the name of the object you're searching
    private val fetch : String = "goblin"

    //Fetch monster
    fun getMonsters() : String {
        //"Monsters" can be replaced with any type in commonMain.kotlin.kson.models.*
        return api.fetch<Monsters>(fetch).name
    }
    
    //Query
    fun queryMonsters() : String {
        //Queries are a little special because they return in a similar structure.
        //Queries available can be found in commonMain.kotlin.kson.Queryable
        //Queries can also take multiple arguments, in this example we use partial 
        //lookup for "evocation" as "evo" and full lookup for "illusion"
        //Return is a comma separated list as a String object.
        return api.query<Spells>(Queryable.Spells.school("evo","illusion"))
    }
    
    //Query Empty
    fun queryEmpty() : String {
        //With queries you can also not send any input and get more information about the Type you're using
        //Example output can be found https://gist.github.com/DrZoddiak/eeb2e9ae9a458c2392be0e1a2155e70b
        return api.query<Spells>(Queryable.Spells.school(""))
    }
}
