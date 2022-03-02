package kson

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import kson.models.Monsters
import kson.models.names
import kotlin.test.Test

private val api = KsonApi(client)

@OptIn(ExperimentalCoroutinesApi::class)
class MonsterTests {
    private val monsters = listOf(
        "goBlin",
        "aColYte",
        "aZer",
        "werewolf-human",
        "brass-draGon-wyrmling"
    )
}