package com.ilozanof.kotlin.learning.classes

/**
 * Examples of Inner and Nested classes
 */

/**
 * An Outer class with 2 inner class: One of them works can access the Outer class, the
 * other cannot.
 */
class Outer {

    val x = 5;

    /**
     * This class is not directly related to the Outer class. It cannot access the
     * outer class fields or methods (unlike in Java)
     */
    class Inner1 {}

    /**
     * But this class CAN access the Outer Class
     */
    inner class Inner2 {
        val y = this@Outer.x
    }
}

/**
 * Now we define a Superclass which is a "sealed" class, meaning that this way we restrict
 * the subclasses that can extend this class.
 */

// TODO: PENDING...

/**
 * A class with no constructors
 */
open class SimpleClass0()


/**
 * Main function
 */
fun main(args: Array<String>) {

}