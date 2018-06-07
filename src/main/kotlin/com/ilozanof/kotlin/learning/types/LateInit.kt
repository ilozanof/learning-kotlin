package com.ilozanof.kotlin.learning.types

/**
 * Examples of the "late Init" keyword
 */

class TestingLateInit() {
    private lateinit var x: String

    fun init() {x = "Initialized"}
    fun print() {println(x)}
}

/**
 * Main function
 */
fun main(vararg args: String) {
    var obj: TestingLateInit = TestingLateInit()
    obj.init()
    obj.print()
}