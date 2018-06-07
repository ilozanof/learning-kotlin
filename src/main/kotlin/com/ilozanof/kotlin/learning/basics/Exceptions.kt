package com.ilozanof.kotlin.learning.basics

/**
 * Examples of use of Exceptions, try-catch-finally, etc.
 */

/**
 * Here we just throw an Exception
 *
 * NOTE that you don't need to declare the Exceptions this functions
 * throws
 */
fun exampleThrowEx() {
    println("\n> exampleThrowEx:")
    val throwIt = true;
    if (throwIt) {
        println("Throwing an Exception...")
        throw Exception("This is an Exception!")
    };
}

/**
 * Example of a try-catch-finally clause
 *
 * NOTE: Even if the exception declared in the CATCH clause is not thrown in the TRY clause,
 * there is NO compilation Error.
 */
fun exampleTryCatchFinally() {
    println("\n> exampleTryCatchFinally:")
    try {
        println("Try clause.")
        Integer.parseInt("parsing this text, it will throw an Exception")
    } catch (e: NumberFormatException) {
        println("Catch clause.")
    } finally {
        println("Finally clause.")
    }
}

/**
 * main Method
 */
fun main(args: Array<String>) {
    try { exampleThrowEx() } catch (e: Exception) {}

    exampleTryCatchFinally();
}