package com.ilozanof.kotlin.learning.basics

import java.util.*

/**
 * Examples of the "For" Loop.
 */

/**
 * Iterating on a range example
 */
fun iterateOnRange() {
    var range = 1..10;
    for (i in range) println("iterating on range, now on ${i}");
}

/**
 * Iterating on a Map
 */
fun iterateOnMap() {
    // We use a Binary Tree to store the binary representation of
    // each Letter.
    val binaryReps = TreeMap<Char, String>();
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt());
        binaryReps[c] = binary;
    }
    // We loop over the Tree, and we print the content. the output
    // will be ordered by the Keys.
    for ((letter, binary) in binaryReps) println("$letter = $binary")
}

/**
 * Man method
 */
fun main(args: Array<String>) {
    iterateOnRange();

    iterateOnMap();
}