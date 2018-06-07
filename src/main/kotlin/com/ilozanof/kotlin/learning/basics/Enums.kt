package com.ilozanof.kotlin.learning.basics

/**
 * A simple Enum
 */
enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

/**
 * A enum with properties and methods
 */

enum class RGB(
    val r: Int, val g: Int, val b: Int
) {
    RED(255,0,0),
    YELLOW(255, 255, 0),
    BLUE(0,0,255);

    fun rgb() = (r * 256 + g) * 256 + b;
}


/**
 * main method
 */
fun main(args: Array<String>) {
    var myRGB: RGB = RGB.BLUE;
    println(myRGB.rgb());
}