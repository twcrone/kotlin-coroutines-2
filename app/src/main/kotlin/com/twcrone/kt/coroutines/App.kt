package com.twcrone.kt.coroutines

import kotlinx.coroutines.*

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() = runBlocking {
    //launch { doEet() }
//    val job = launch {
//        repeat(1000) {
//            println("job: I'm sleeping $it ...")
//            delay(500L)
//        }
//    }
//    delay(1300L)
//    println("Canceling...")
//    job.cancel()
//    job.join()
//    println("Done")
    val start = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = start
        var i = 0
        try {
            repeat(1000) { i ->
                println("job: sleeping $i ...")
                delay(500L)
            }
        } finally {
            println("job: finally")
        }
//        while (isActive) {
//            if(System.currentTimeMillis() >= nextPrintTime) {
//                println("job: I'm sleeping ${i++} ...")
//                nextPrintTime += 500L
//            }
//        }
    }
    delay(1300L)
    println("Trying to cancel...")
    job.cancelAndJoin()
    println("Done")
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