package com.twcrone.kt.coroutines

import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class AppTest {

    @Test
    fun firstTest() = runBlocking {
        doWork()
    }
}
