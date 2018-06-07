package com.ilozanof.kotlin.learning.classes

/**
 * The following class implements the universal methods toString, hashCode and equals.
 */

class Client(val name: String, val postalCode: Int) {
    // We override "toStrinf"
    override fun toString() = "Client(name=$name, postalCode=$postalCode)"

    // We override "equals".
    // NOTE: We use smartCast here.
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client)
            return false
        else {
            return (name == other.name && postalCode == other.postalCode)
        }
    }
    // We override "hashCode"
    override fun hashCode(): Int = name.hashCode() * 31 + postalCode
}

fun main(vararg args: String) {
    var obj: Client = Client("John", 23232)
    println(obj)
}