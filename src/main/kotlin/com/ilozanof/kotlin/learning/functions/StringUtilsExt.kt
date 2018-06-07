package com.ilozanof.kotlin.learning.functions


/**
 * This is an example of an extension function. We are adding functionality to
 * the built-in String class in Java, adding a method for finding the last character
 * within the String.
 */
fun String.lastChar(): Char = this.get(this.length - 1)


/**
 * This is an example of an extension Property, this time we add a property to
 * the "StringBuilder" class.
 */

var StringBuilder.lastChar: Char
    get() = get(0)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }


/**
 * This is another version of the "joinToString" defined in "StringUtils.kt", but this time
 * is coded as an extension on the Collection class.
 *
 * NOTE: WE are using the default values defined as variables in the StringUtil.kt file,
 * we cannot define the same variables here.
 *
 * And this function needs to be defined in a separate file, if we define it in
 * "StringUtils.kt", we are geeting a conflict error (same signature?)
 */

fun <T> Collection<T>.joinToString(separator  : String = defaultSeparator,
                                   prefix     : String = defaultPrefix,
                                   postfix    : String = defaultPostix) :String {

    val result = StringBuffer(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    } // for...
    result.append(postfix)
    return result.toString()
}



/**
 * main method
 */
fun main(args: Array<String>) {
    println(listOf(1,2,3,4,5).joinToString())

    val strB = StringBuilder()
    strB.append("Hello Man")
    println(strB.lastChar)
}