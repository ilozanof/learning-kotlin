package com.ilozanof.kotlin.learning.basics

/**
 * Another version of the function above, this time making use of
 * the "arg" parameters and String templates.
 */
fun example(args: Array<String>) {
    var msg = if (args.size > 0) args[0] else "Kotlin";
    println("Hello $msg");
    if (args.size > 0) println("Hello ${args[0]} again!");
}

/**
 * A function the returns a type.
 * This is a BLOCK BODY
 */
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b;
}

/**
 * Another version of the function above, this time removing
 * the body declaration and using the "=" character to implement
 * the body directly.
 *
 * This is an EXPRESSION BODY
 */
fun max2(a: Int, b: Int): Int = if (a > b) a else b;


/**
 * Another version of the function above, this time even removing the
 * retun type.
 *
 * This is another EXPRESSION BODY, this time without return type. But
 * the compiler can infer the type from he one-line expression
 */
fun max3(a: Int, b: Int) = if (a > b) a else b;


/**
 * A function equivalent to a "public static void main" method in JAVA.
 * It can be declared with an outer class, and in a separate .kt file.
 */
fun main(args: Array<String>) {
    println("Hello World Kotlin!");
}