package com.ilozanof.kotlin.learning.basics

/**
 * Another class with more properties. This time, the additional
 * property is a muttable one.
 */
class PersonMore(val name: String, var isMarried: Boolean) {
    var sex: String = "Woman";
    val isSpanish : Boolean
        get () = true;
}

/**
 * The next function shows how to use the propertyes from the Class above
 */

fun usingPersonMore(){
    var person: PersonMore = PersonMore("Mike", true)
    person.sex = "Man"
    println("Using PersonMore with ${person.name}, married: ${person.isMarried},"
            + " sex:${person.sex}, isSpanish:${person.isSpanish}")

}

/**
 * Main method
 */
fun main(args: Array<String>) {
    usingPersonMore();
}
