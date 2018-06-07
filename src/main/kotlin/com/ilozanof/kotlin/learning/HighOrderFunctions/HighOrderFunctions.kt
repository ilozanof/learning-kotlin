package com.ilozanof.kotlin.learning.HighOrderFunctions

import java.util.function.Predicate

/**
 * Example of High Level Functions
 */

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}

/**
 * Main method
 */
fun main(vararg args: String) {
    twoAndThree({ x, y -> x + y })
}