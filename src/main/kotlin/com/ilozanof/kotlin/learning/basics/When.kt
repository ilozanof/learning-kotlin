package com.ilozanof.kotlin.learning.basics

/**
 * Different examples of the "When" expression.
 *
 */


/**
 * function that usesd the "When" clause
 */

fun getColorName(color: RGB) =
        when (color) {
            RGB.BLUE    -> "Blue"
            RGB.YELLOW  -> "Yellow"
            RGB.RED     -> "Red"
        } // when...

/**
 * Function that uses the "When" clause with arbitrary objects
 * (not only constant expressions, like Java.
 *
 * This is a very complicated way of checking if 2 enums
 * are the same or not...
 */
fun areSameColor(c1: RGB, c2: RGB) =
        when(setOf(c1, c2)) {
            setOf(RGB.RED, RGB.RED)         -> true
            setOf(RGB.BLUE, RGB.BLUE)       -> true
            setOf(RGB.YELLOW, RGB.YELLOW)   -> true
            else -> false
        } // when...


/**
 * Another version of the function above, using the "When" expression WITHOUT an argument
 */
fun areSameColor2(c1: RGB, c2: RGB) =
        when {
            (c1 == RGB.YELLOW && c2 == RGB.YELLOW)  -> true
            (c1 == RGB.RED && c2 == RGB.RED)        -> true
            (c1 == RGB.BLUE && c2 == RGB.BLUE)      -> true
            else -> false
        } // when...

/**
 * We define a marker interface and another class, just for the sake of this
 * small example
 */

interface ColorBase;
class ColorBase1 : ColorBase;
class ColorBase2 : ColorBase;

/**
 * Another function that uses the parameter in the "When" clause, but
 * it does NOT use the implicit EQUALS condition on each branch, instead
 * it uses a "partial" boolean expression (the left part of the expression
 * is the part used in the "When" expression)
 *
 */
fun getColorType(color: ColorBase) =
        when (color) {
            is ColorBase1 -> "ColorBase1"
            is ColorBase2 -> {
                // We do some stuff here...
                println("checking if the color is a ColorBase2...")
                // and we return the result...
                "ColorBase2"
            }

            else -> "Unknown"
        } // when...



/**
 * main method
 */
fun main(args: Array<String>) {
    System.out.println(getColorName(RGB.RED))

    println(areSameColor(RGB.YELLOW, RGB.RED))
    println(areSameColor(RGB.YELLOW, RGB.YELLOW))

    println(areSameColor2(RGB.YELLOW, RGB.RED))
    println(areSameColor2(RGB.YELLOW, RGB.YELLOW))

    println(getColorType(ColorBase1()))
    println(getColorType(ColorBase2()))
}