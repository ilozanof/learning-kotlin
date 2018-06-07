package com.ilozanof.kotlin.learning.lambdas

import com.ilozanof.kotlin.learning.basics.Person
import com.ilozanof.kotlin.learning.classes.User
import com.ilozanof.kotlin.learning.classes.WebUser


/**
 * Examples of Lambda expressions written as Member References.
 */

data class Item(val name: String) : Comparable<Item> {
    override fun compareTo(other: Item): Int {
        return this.name.compareTo(other.name)
    }
}

class TestingMemberRef {
    fun testing() {

        val list: List<Item> = listOf(Item("John"),
                                      Item("Mike"),
                                      Item("Smith"))

        // We find the first one whose name starts with "M"
        var found : Item? = list.maxBy { i -> i.name }

        println("Number found: ${found?.name}")

        // Another way to fo the exact same thing...
        // NOTE: We HAVE TO use parenteisis in this case
        found = list.maxBy ( Item::name )
        println("Number found: ${found?.name}")

    }
    // TODO: Pending to add more examples (like invoking Comstructors, and th rest of Member References possible syntax
}

/**
* Main function
*/
fun main(vararg args: String) {
    val obj = TestingMemberRef()
    obj.testing()
}
