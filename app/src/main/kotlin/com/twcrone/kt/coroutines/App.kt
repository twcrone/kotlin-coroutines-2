package com.twcrone.kt.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() = runBlocking {
    launch { doEet() }
    println("Done")
}

suspend fun doEet() = coroutineScope {
    launch {
        delay(2000L)
        println("Eeet Again!!!")
    }
    launch {
        delay(1000L)
        println("Eeet!!!")
    }
    println("Do")
}