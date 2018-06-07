package com.ilozanof.kotlin.learning.types

/**
 * Examples of Nullability in Kotlin:
 * - "Safe Call" operator
 * - "Elvis" operator
 * - "Safe Cast" operator
 * - "Not Null" assertions
 * - The "let" function
 */

/**
 * A small class for testing
 */

data class Value(var x: String) {}

/**
 * Our main class
 */
class NullabilityTest {

    /**
     * We testing the "Safe Call" operator in this function
     */
    fun testSafeCall() {
        println("> testing Safe Call operator...")
        val value: Value = Value("instance-no-null")
        val valueNullable: Value? = null

        // We print both values. In the case of th Nullable value, we need to use
        // the "Safe Cqll" operator, and since we are printing it inside a string, we
        // also need to use the brackets.
        println("Value: ${value.x}")
        println("Value nullable: ${valueNullable?.x}")
    }

    /**
     * We test the "Elvis" operator
     */
    fun testElvisOperator() {
        println("> testing Elvis operator...")
        var valueNullable: Value? = null

        // For testing: Comment and un-comment this line:
        valueNullable = Value("I have a Value!")

        // If "valueNullable" is null, the next sentence prints "no-value",
        // otnherwise it prints the value of "valueNullable.x"

        val msg = valueNullable?.x ?: "no-value"
        println("The value is: $msg")
    }

    /**
     * We test the "Safe Cast" operator
     * Id the "obj" parameter is a "Value" object, we rturn TRUE, and FALSE otherwise
     *
     * @param obj parameter
     *
     */
    fun isValueObject(obj: Any?) : Boolean {
        val value = obj as? Value ?: return false
        return true
    }

    /**
     * We test the Not-Null assertions
     */
    fun testingNotNullAssertions(value: Value?) {

        println("> testing Not-Null Assertions..")
        // Inst4ad os using the "Safe Call" operator this time, we use the not-null assertion,
        // so we trick the compiler into thinking that the parameter is always going to be
        // not-null

        // If the parameter is actually not-null, we print its value.
        // If the parameter is null, we get a Null Pointer Exception!
        println("Value passed as a parameter: ${value!!.x}")
    }

    /**
     * We test the "let" function.
     * If the "msg" received is not null, we print it, otherwise we do nothing
     *
     * @param msg message to print
     */
    fun testingLet(msg: String?) {
        msg?.let { println(it) }
    }
}

/**
 * the following function is an extension of the String object, so we can check if an
 * String is Blank or null, even if the object itself is null
 */
fun String?.isNullOrBlank(): Boolean = (this == null || this.isBlank())



/**
 * Main Function
 */
fun main(vararg args: String) {
    val obj: NullabilityTest = NullabilityTest()
    obj.testSafeCall()
    obj.testElvisOperator()

    println("Is this a Value Object? ${obj.isValueObject(null)}")
    println("Is this a Value Object? " + obj.isValueObject(Value("yes, its a Value object now")))

    obj.testingNotNullAssertions(Value("This is value"))
    //obj.testingNotNullAssertions(null)

    println("We are going to print a message not-null...")
    obj.testingLet("This is Very important Message!")
    println("Now we are going to print a null message...")
    obj.testingLet(null)

    println("Checking if an String is null or Blank...")
    val str1: String = "I'm not null"
    val str2: String? = null
    val str3: String = ""

    println("Is str1 null or Blank? ${str1.isNullOrBlank()}")
    println("Is str2 null or Blank? ${str2.isNullOrBlank()}")
    println("Is str3 null or Blank? ${str3.isNullOrBlank()}")
}