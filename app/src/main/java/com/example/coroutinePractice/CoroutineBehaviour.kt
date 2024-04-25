package com.example.coroutinePractice

fun main() {
    callBassam(1)
}

fun callBassam(number: Int) {
    when (number) {
        1 -> {
            println("task bassam: $number")
            callFarouk(1)
        }
        2 -> {
            println("task bassam: $number")
            callFarouk(2)
        }
        3 -> {
            println("task bassam: $number")
            callFarouk(3)
        }
    }
}

fun callFarouk(number: Int) {
    when (number) {
        1 -> {
            println("task farouk: $number")
            callBassam(2)
        }
        2 -> {
            println("task farouk: $number")
            callBassam(3)
        }
        3 -> {
            println("task farouk: $number")
            callBassam(4)
        }
    }
}