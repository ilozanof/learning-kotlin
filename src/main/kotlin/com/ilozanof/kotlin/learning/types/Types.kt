package com.ilozanof.kotlin.learning.types

/**
 * Examples of the Kotln types and some useful operators
 */

data class Var(val x: String) {}

/**
 * This function needs the parameter "x" to be NOT-Null
 */
fun printVar(v: Var) {
    println(v.x)
}

/**
 * This function does the same thing, but it can work with
 * Nullable Variables.
 * It uses the "Safe call" operator
 */
fun printVarNullable(v: Var?) {
    println(v?.x)
}



/**
 * Main Function
 */
fun main(vararg args: String) {
    var myVar: Var = Var("not-null")
    var myVarNullable: Var?  = null

    printVar(myVar)
    printVarNullable(myVar)
    printVarNullable(myVarNullable)

    // This line does NOT compile
    //printVar(myVarNullable)

    // Now we are using the "Elvis operator".
    // If the "x" property of the "myVarNullable" is not null (and if "myVarNullable" itself is not
    // null), then its value is assigned to "msg", otherwise null is assigned.
    val msg: String? = myVarNullable?.x  ?: " "
    println(msg)

    // Now we are using the Safe Cast (as?)
    // TODO: PENDING...

    // Now we are using the Not-null assertions
    // TODO: PENDING...

    // Now we are using the "let" function
    println("Using the 'let' function...")
    myVar?.let { printVar(it) }
    myVarNullable?.let { printVar(it) }
}