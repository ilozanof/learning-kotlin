package com.ilozanof.kotlin.learning.classes

/**
 * Examples of use of the constructors
 */

/**
 * A class with a default/implicit constructor
 */
open class SimpleClass1 (_x: Int) {
    val x = _x
}

/**
 * Another class equivalent to the previous one, this one we add the "val" keyword to
 * the parameters, which makes to compiler add a property "x" to the class, and ONLY
 * a getter for that property.
 */
open class SimpleClass1b (val x: Int)

/**
 * A class with a Primary constructor
 * NOTE: The "Constructor" declaration goes along with the Class declaration, and we
 * use the "init" keyword to speciffy the body of the constructor.
 */
open class SimpleClass2 constructor (_x: Int) {
    val x: Int

    init {
        x = _x
    }
}

/**
 * Another version similar to the previous class (more Java-style), but with
 * more than one constructor this time.
 * These are called SECONDARY CONSTRUCTORS
 */
class SimpleClass2b {
    var x: Int
    constructor (_x: Int) {
        x = _x
    }
    constructor(_x: Int, _y: Int) {
        x = _x + _y
    }
}


/**
 * A class with a primary constructor PRIVATE, so it cannot be instantiated
 */
open class SimpleClass3 private constructor(_x: Int) {
    val x: Int
    init {
        x = _x
    }
}

/**
 * Another version of the previous class (more Java-style)
 */
open class SimpleClass4 {
    var x: Int
    private constructor(_x: Int) {
        x = _x
    }
}

/**
 * Now we are going to extend the "SimpleClass2" class, using the constructors
 * properly
 */

// We extend a class with no constructors
class SimpleChild0(): SimpleClass0()

// We extend a class with no constructors, but there is one in the child
class SimpleChild0b(val _X: Int): SimpleClass0()

// We extends a class that has a constructor but the child does not:
class SimpleChild1 () : SimpleClass1 (5)

// We extends a class and both (parent and child) have a constructor with same parameters
// In the default constructor in the child, we initialize the one in the parent.
class SimpleChild2(val _x: Int) : SimpleClass1 (_x)

/**
 * Man function
 */
fun main(vararg args: String) {
    // We create instances of the classes defined previously...
    val simple1 = SimpleClass1(1)
    val simple1b = SimpleClass1b(2)
    val simple2 = SimpleClass2(3)

    println(simple1.x)
    println(simple1b.x)
    println(simple2.x)
}