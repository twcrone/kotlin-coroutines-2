package com.twcrone.kt.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

var acquired = 0

class Resource {
    init { acquired++}
    fun close() { acquired-- }
}

fun main() {
    runBlocking {
        val time = measureTimeMillis {
            val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
            val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
            one.start()
            two.start()
            println("The answer is ${one.await() + two.await()}")
        }
        println("Completed in $time ms")
//        repeat(100_000) {
//            launch {
//                var resource: Resource? = null
//                try {
//                    withTimeout(60) {
//                        delay(50)
//                        resource = Resource()
//                    }
//                } finally {
//                    resource?.close()
//                }
//            }
//        }
    }
    //println(acquired)
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