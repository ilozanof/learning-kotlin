package com.ilozanof.kotlin.learning.basics

/**
 * Examples of expressions (If, When, Try, etc) that can be used as values and
 * assigned to variables
 */

/**
 * Example using the "If" expression.
 * This function returns whether the parameter
 * is an Odd number or not.
 */
fun exampleIsOddIf(number: Int): Boolean {
    println("\n > exampleIf:")
    val result = (number % 2 == 0)
    println("isOdd: $result")
    return result
}

/**
 * Example using the "When" expression.
 * This function returns whether the parameter
 * is an Odd number or not.
 */
fun exampleIsOddWhen(number: Int) = when {
    (number % 2 == 0) -> true
    else -> false
}

/**
 * Example using the "Try" expression.
 * This function returns whether the parameter
 * is an Odd number or not.
 *
 * In case the number is higher that 10, this function
 * throws an Exception.
 */
fun exampleIsOddTry(number: Int) = try {
        if (number > 10) throw Exception("Numbers > 10 not supported!")
        (number % 2 == 0)
    } catch (e: Exception) {
        false
    }

/**
 * Main method
 */
fun main(args: Array<String>) {
    println("\n > Main...")
    var number = 5
    println("isOdd using If: ${exampleIsOddIf(number)}")
    println("isOdd using When: ${exampleIsOddWhen(number)}")
    println("isOdd using Try: ${exampleIsOddTry(number)}")
    println("\n > End of Main.")
}