package com.ilozanof.kotlin.learning.lambdas

import com.ilozanof.kotlin.learning.basics.Person

/**
 * Examples of Lambda expressions in Kotlin
 */

val sum = {x: Int, y: Int -> x + y}

// NOTE: You ust specify the type of both parameters, the following
// line does NOT compile
// val sum2 = {x, y -> x + y}


/**
 * Main function
 */
fun main(vararg args: String) {
    println("Adding 2 numbers: ${sum(2,3)}")
    println(run { 2 + 3})
    println(run{sum(2,3)})

    // Now we are using lanbas in a Collection, and also use the short syntax, to
    // reduce boilerplate code...

    val personsList: List<Person> = listOf( Person("John"),
                                            Person("Mike"),
                                            Person("Julia"))

    // We find the ones which name starts with 'J'...
    // All the next sentences are the same:

    var found: Person? = personsList.find({p: Person -> p.name.startsWith("J")})
    println("Person found: ${found?.name}")

    // The same, removing the type, since can be inferred
    found = personsList.find({p-> p.name.startsWith("J")})
    println("Person found: ${found?.name}")

    // The same, removing parentesis
    found = personsList.find {p -> p.name.startsWith("J")}
    println("Person found: ${found?.name}")

    // Now, let's see what happens when it does not find anythiong and we still try top
    // print the content...
    found = personsList.find {p -> p.name.startsWith("X")}
    println("Person found: ${found?.name}")
    // Result: Person found: null
}