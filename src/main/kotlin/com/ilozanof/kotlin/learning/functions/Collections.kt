package com.ilozanof.kotlin.learning.functions

/**
 * Examples of use of Collections.
 * NOÇTE: Some functions are invoked but not defined in this file, but in the StringFunctions.kt file instrad.
 */

/**
 * Very basic oexample of creating collections in Kotlin
 */
fun createCollections() {
    println("\n > createCollection:")

    // We create collections using the built-ín Kotlin functions:
    val set     = setOf(1, 5, 2)
    val list    = listOf(1, 5, 2)
    val map     = mapOf(1 to "one", 5 to "five", 2 to "two")

    // Now we print the classes that each one of these collectiosn represents:
    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)
}


/**
 * Main Function
 */
fun main(args: Array<String>) {
    println("\n > Main...")
    // Testing creating collections...
    createCollections()

    // Testing formatting a Collection and using default parameters...
    val list = listOf(1,2,3,4,5)
    println("formatted collection: ${joinToString(list, ",", "<", ">")}")

    println("\n > Main End.")
}