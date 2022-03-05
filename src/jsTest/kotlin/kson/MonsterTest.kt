package kson

import kotlinx.coroutines.ExperimentalCoroutinesApi

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