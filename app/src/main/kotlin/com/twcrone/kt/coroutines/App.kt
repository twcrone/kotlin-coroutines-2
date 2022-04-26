package com.twcrone.kt.coroutines

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
    launch { eet() }
    println("Do")
}

suspend fun eet() {
    delay(1000L)
    println("Eeet!!!")
}