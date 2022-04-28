package com.twcrone.kt.coroutines

import kotlinx.coroutines.*
import java.lang.Thread.sleep
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

var acquired = 0

class Resource {
    init { acquired++}
    fun close() { acquired-- }
}

fun main() {

    GlobalScope.launch {
        delay(1000)
        print("World")
    }

    print("Hello, ")
    sleep(1500)
}

fun old_main() {

    thread {
        sleep(1000)
        println("World")
    }

    print("Hello, ")
    sleep(1500)
}

suspend fun repeatLaunch() = coroutineScope {
    repeat(100_000) {
        launch {
            delay(500L)
            print(".")
        }
    }
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

suspend fun doSomethingUsefulOne(): Int {
    delay(1000L)
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L)
    return 29
}