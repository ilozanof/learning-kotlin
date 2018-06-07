package com.ilozanof.kotlin.learning.classes

/**
 * Examples of Visibility modifiers
 */

/**
 * This is a class ONLY visible within this MODULE
 */

internal class MyButton : Clickable {
    override fun click() {
        println("MyButton is clicking!!!")
    }
}

// TODO: WE NEED TO ADD MORE EXAMPLES HERE
// Now we define an extension function. Even though the function
// is en extension of the internal class, the function itself is
// a PUBLIC one, so in this case we would get an ERROR:

//fun MyButton.anotherClick() = println("Another Click!")

// But this one works just fine:

internal fun MyButton.anotherClick() = println("Another Click!")
