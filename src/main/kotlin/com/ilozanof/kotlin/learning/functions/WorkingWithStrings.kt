package com.ilozanof.kotlin.learning.functions

/**
 * Here we'll show some usecases of working with Strings
 */

/**
 * BAsic example of some String functions
 */
fun example() {
    // Splitting a String
    var str = "12.346-231-abc.ABC"
    println(str.split(".","-"))

    // Using triple-quoted Strings...
    val msg = """ This a multiline
                  msg, let's see what it looks like
                  in the screen"""
    println(msg)
}


/**
 * This is a function that take a String containing a full path, and prints some data
 * about it, like filename and extension, etc.
 */
fun printPathInfo(path: String) {
    val directory    = path.substringBeforeLast("/")
    val fullFileName = path.substringAfterLast("/")
    val fileName     = fullFileName.substringBeforeLast(".")
    val extension    = fullFileName.substringAfterLast(".")

    println("directory: $directory, fileName: $fileName, extension: $extension")
}

/**
 * Main function
 */
fun main(args: Array<String>) {
    example()
    printPathInfo("usr/local/testing.txt")
}