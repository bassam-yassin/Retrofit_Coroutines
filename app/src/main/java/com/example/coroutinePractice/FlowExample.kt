package com.example.coroutinePractice

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// Is it Async or Sync?
// How to make it the opposite ?
@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking {
    val jop = GlobalScope.launch {
        testFlow()
        testFlowOf()
        testAsFlow()
    }
    jop.join()
}

suspend fun testFlow() {
    flow {
        (0..10).forEach {
            emit(it)
        }
    }.flowOn(Dispatchers.Default).map {
            it * it
        }.collect {
            println("$it")
        }
}

suspend fun testFlowOf() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    flowOf(numbers).map {
        it.subList(3, 6)
    }.collect {
        println("$it")
    }
}


suspend fun testAsFlow() {
    (1..5).asFlow().collect {
        println("$it")
    }
}

