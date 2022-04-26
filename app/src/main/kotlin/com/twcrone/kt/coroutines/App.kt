package com.twcrone.kt.coroutines

import kotlinx.coroutines.*

var acquired = 0

class Resource {
    init { acquired++}
    fun close() { acquired-- }
}

fun main() {
    runBlocking {
        repeat(100_000) {
            launch {
                var resource: Resource? = null
                try {
                    withTimeout(60) {
                        delay(50)
                        resource = Resource()
                    }
                } finally {
                    resource?.close()
                }
            }
        }
    }
    println(acquired)
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