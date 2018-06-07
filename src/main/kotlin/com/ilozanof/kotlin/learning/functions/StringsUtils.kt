/**
 * This is an example of a file containing utility functions. These funtions are
 * stored here, and if called from Java, these classes will become static method
 * of a class which name is the same as thename of this file.
 */

package com.ilozanof.kotlin.learning.functions

import com.sun.xml.internal.fastinfoset.util.StringArray

/**
 * These are examples of top-level variables, which will become static variables
 * when compiled to Byte-code.
 * NOTE: WE mark them as "const", so they can be accessed as public final fields
 */

const val defaultPrefix     = ""
const val defaultPostix     = ""
const val defaultSeparator  = ", "

/**
 * This is a helper function ot print the elements within a Collection using
 * specific characters. Here we are using:
 *  - a Generic Function, (<T>)
 *  - default parameters
 */

fun <T> joinToString(collection : Collection<T>,
                     separator  : String = defaultSeparator,
                     prefix     : String = defaultPrefix,
                     postfix    : String = defaultPostix) :String {

    val result = StringBuffer(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    } // for...
    result.append(postfix)
    return result.toString()
}

/**
 * This is an example of a function that uses a varargs argument as a
 * parameter
 */
fun concatenate(vararg strings: String) : String {
    val result = StringBuffer()
    if (strings.isNotEmpty())
            for (str in strings) result.append(str);
    return result.toString()
}

/**
 * Main function
 */
fun main(arbgs: Array<String>) {
    println("testing the joinToString function...")
    println(joinToString(listOf(1,2,3,4,5), "-", "[", "]"))
    println("testing the 'lastChar' extended function...")
    println("Kotlin".lastChar())
    println("testing the concatenate function...")
    println(concatenate("This ", "is ", "a ", "string"))
    val params: Array<String> = arrayOf("This ", "is ", "a ", "string ")
    println(concatenate(*params))

}