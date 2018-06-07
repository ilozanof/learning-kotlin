package com.ilozanof.kotlin.learning.classes

/**
 * This is an example of a feature included in Kotlin, which help us implement
 * the "Decorator" Pattern: the use of the "by" keyword.
 *
 * In this example, the class "myList" imp,lements the same methods as the "Collection"
 * interface, but each one of the Collection methods delegates on he same method (same
 * signature) of another class, used in the constructor.
 */

class MyCollection<E> (val innerCollection: MutableCollection<E> = ArrayList<E>()) : MutableCollection<E> by innerCollection {
    // All the methods of the Collection interface are delegated to the ones in "innerCollection",
    // But the "add" method is overriden so We added some custom logic here...
    override fun add(element: E): Boolean {
        return innerCollection.add(element)
        println("adding an element...")
    }
}

/**
 * Main function
 */
fun main(vararg args: String) {
    val obj: MyCollection<Int>  = MyCollection<Int>()
    obj.add(5)
    println("size: ${obj.size}")
}