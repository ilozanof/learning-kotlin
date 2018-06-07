package com.ilozanof.kotlin.learning.lambdas

/**
 * Examples of access to different scopes and variables from within a Lambda
 * expression
 */


class TestLambdas {
    /**
     * In this function, we use a PRODUCER to iterate over the elements in
     * a list, using a LAMBDA. In that lambda we make reference to the local
     * variables "x" and "y"
     *
     * NOTE: We can make reference to non-final variables, unlike Java.
     */
    fun testingScope() {
        val x = 5
        var y = 4
        val list: List<Int> = listOf(1,2,3,4,5)
        list.forEach {n -> println("> ${n + x + y}")}
    }
}

/**
 * Main function
 */
fun main(vararg args: String) {
    val obj: TestLambdas = TestLambdas()
    obj.testingScope()
}


