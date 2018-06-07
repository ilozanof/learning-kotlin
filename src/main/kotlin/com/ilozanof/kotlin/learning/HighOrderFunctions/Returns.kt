package com.ilozanof.kotlin.learning.HighOrderFunctions

import com.ilozanof.kotlin.learning.basics.Person

/**
 * EXamples of "returns" or "non-local returns" in Kotlin
 */

/**
 * First, a regular example with no lambdas.
 */
fun lookForAlice(people: List<Person>) {
    for (person in people) {
        if (person.name == "Alice") {
            println("Found!")
            return
        }
    }
    println("Alice is not found")
}

/**
 * This is an example of a non-local return. When the lambda function returns,
 * the execution flow returns from the function enclosing the lamda.
 */
fun lookForAlice2(people: List<Person>) {
    people.forEach {
        if (it.name == "Alice") {
            println("Found!")
            return
        }
    }
    println("Alice is not found")
}

/**
 * Another version, tjhis time using the same lambda expression BUT with a local-return and a
 * LABEL. So in thi case, the local-returns works more like a BREAK statement in a loop.
 */
fun lookForAlice3(people: List<Person>) {
    people.forEach label@ {
        if (it.name == "Alice") {
            println("Found! and returning...")
            return@label
        }
    }
    println("We reach the end of the loop!")
}

/**
 * Another version, this time using an anonymous function. In this case, the returns is alwways a
 * local-return, since the "returns" goes back to the closes function when we are using the "fun"
 * keyword (with lambdas we are Not using the "fun" keyword, that's why it's different for them.
 */
fun lookForAlice4(people: List<Person>) {
    people.forEach(fun (person) {
        if (person.name == "Alice") {
            println("Found!")
            return
        }
    })
    println("After looking for Alice...")
}

/**
 * Main method
 */
fun main(vararg args: String) {
    val people = listOf(Person("John"), Person("Alice"), Person("Mike"))
    println("> Looking for people the traditional way:")
    lookForAlice(people)

    println("> Looking for people with lambdas and non-local returns")
    lookForAlice2(people)

    println("> Looking for people wiht lambdas and local-returns")
    lookForAlice3(people)

    println("> Looking for people using anonymous functions...")
    lookForAlice4(people)
}