package com.ilozanof.kotlin.learning.classes

import com.ilozanof.kotlin.learning.basics.Person

/**
 * This is an example of another Kotli feautre which help us develop Singletons easily, by using
 * the "object" keyword: At the same time the class is defined, only one instance of that class
 * is created and instantiated.
 */

object Payroll {
    val allEmployees = arrayListOf<Person>()

    //  We initialize the array of employees, invoking a function
    // We have to use anm "init" block, since we cannot use a constructor inside an "object"
    init {
        initEmmployees()
    }

    private fun initEmmployees() {
        for (number in 1..10) allEmployees.add(Person("employee-$number"))
    }
    fun calculateSalary() {
        for (person in allEmployees) println("calculating Salary of ${person.name} ...")
    }
}

/**
 * Main function
 */
fun main(vararg args: String) {
    Payroll.calculateSalary()
}