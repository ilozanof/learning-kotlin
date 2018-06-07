package com.ilozanof.kotlin.learning.overloading

/**
 * Examples of Destructiuring Declarations and component Functions
 */

/**
 * A simple data class that stores the components of a path:
 * - The path without the file extension
 * - the extension of the file
 */
data class NameComponents(val name: String,
                          val extension: String)

/**
 * A funciton that, given a full path, returns its components as a
 * "NameComponents" instance.
 */
fun splitFileName(fullName: String): NameComponents {

    val result = fullName.split("\\.".toRegex(), 2)
    return NameComponents(result[0], result[1])
}

/**
 * main function
 */
fun main(vararg args: String) {

    // We use s desestructure variable declaration to get the two different values in 2 different
    // variables:
    val (path, extension) = splitFileName("usr/local/bin/myFile.txt")

    println("path: $path, extension: $extension")
}