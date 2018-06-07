package com.ilozanof.kotlin.learning.functions

/**
 * In this file we are using functions defined in other external files,
 * like "StringUtils.kt" and "StringUtilsExt.kt"
 */

// We import the extension classes...
// Here there is no real need, since we are in the same package already...

import com.ilozanof.kotlin.learning.functions.lastChar

/**
 * Main function.
 *
 */
fun main(args: Array<String>) {
    println("Hello  Kotlin!".lastChar())
}