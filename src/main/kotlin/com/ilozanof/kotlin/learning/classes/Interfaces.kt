package com.ilozanof.kotlin.learning.classes

/**
 * Examples of interfaces and implementations
 */


/**
 * A very simple interface
 */
interface Clickable {
    // A method that needs to be implemented
    fun click()
    // A default implementation for another method:
    fun showOff() = println("I'm clickable!")
}


/**
 * An example implementation
 * NOTES:
 * - The "override" keyword is MANDATORY in Kotlin
 * - the class is "open", so it can be extended.
 * - The "showOff()" method is overriden the method from the interface, so it's open by
 * default. We mark it as "final" to prevent other subclasses to overwrite it.
 */
open class Button : Clickable {
    override fun click() = println("Clicking Button!")
    final override fun showOff() {
        super.showOff()
        println("[implementing class]")
    }
}


/**
 * An example of an Abstract Class
 */

abstract class LightButton  {
    abstract fun doSomething()
}

/**
 * An interface with a property. All the classes implementing this interface should provide
 * a way to retreive this property's value
 */
interface User {
    val nickname: String
}

// Here we have different implementations of the interface above
// In this case we use the parameter in the constructor to work as the
// the "nickname" proerty, so we use the "overide" keyword.
class PrivateUser(override val nickname: String): User

// In this case, we override the property directly, implementing the getter method.
class SiubscribingUser(val email: String) : User {
    override val nickname: String
    get() = email.substringBefore('@')
}
