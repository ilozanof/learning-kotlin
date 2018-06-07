package com.ilozanof.kotlin.learning.overloading

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.reflect.KProperty

/**
 * Examples of Delegated properties.
 */

// =====================================================
// First, an example WITHOUT using Delegated Properties:
// =====================================================

/**
 * This class is a repository of ChangeListeners
 */
open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

/**
 * This class represents a Person, storing a few variables about it. For those
 * mutable properties, it implements a custom setter, which triggers a change in
 * the "propertyChangeAware" property. If there are any listeners registeres in it,
 * those listeners wil be triggered.
 */
class Person (val name: String, age: Int, salary: Int) : PropertyChangeAware() {

    var age: Int = age
        set(newValue) {
            val oldValue = field // "field" is a special Keyword
            field = newValue
            changeSupport.firePropertyChange("age", oldValue, newValue)

        }

    var salary: Int = age
        set(newValue) {
            val oldValue = field // "field" is a special Keyword
            field = newValue
            changeSupport.firePropertyChange("salary", oldValue, newValue)

        }
}

/**
 * We test the first example, WITHOUT usin Delegate Properties
 */

fun testWithoutDelegateProps() {

    println("> Testing WITHOUT Delegating properties...")

    // We create a Person...
    val person: Person = Person("Jhon", 23, 34500)

    // We register a istener,that will lister for any change in ANY property in this class...
    person.addPropertyChangeListener(
            PropertyChangeListener {event -> println("Property ${event.propertyName} changed " +
                    "from ${event.oldValue} to ${event.newValue}")
            }
    )

    // We change some properties, to check the listeners are triggered...
    person.age = 21
    person.salary = 24000
}

// =====================================================
// Second, an example encapsulating the "events" logic
// in a separate class
// =====================================================


class ObservableProperty (val propName: String,
                          var propValue: Int,
                          val changeSupport: PropertyChangeSupport) {
    fun getValue(): Int = propValue
    fun setValue(newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(propName, oldValue, newValue)
    }
}

/**
 * Ne version of the "Person" class.
 * Now each property is defined as a "Observable" Property, so the triggering-even thing
 * is encapsualted in the previous class. However, to the resto of the putside world, the
 * properties should be String or Int, not "Obervable". So we need to implement custom accessor
 * in order to return the right types
 */
class Person2(val name: String,
              age: Int,
              salary: Int): PropertyChangeAware() {
    private var _age = ObservableProperty("age", age, changeSupport)
    var age: Int
        get() = _age.getValue()
        set(value)  {_age.setValue(value)}

    private var _salary = ObservableProperty("salary", salary, changeSupport)
    var salary: Int
        get() = _salary.getValue()
        set(value)  {_salary.setValue(value)}

}

/**
 * Now we test the second Example, using a Observable Class to encapsulate the "event-firing" logic
 */
fun testingObservable() {

    println("> Testing with OBSERVABLE properties...")

    // We create an instance of Person2...
    val person2: Person2 = Person2("Mike", 35, 52000)

    // We add a listener to any change in any property, so it prints out a message
    person2.addPropertyChangeListener(
            PropertyChangeListener {event -> println("Property ${event.propertyName} changed " +
                    "from ${event.oldValue} to ${event.newValue}")
            }
    )

    // Now we change some things, to trigger the listener...
    person2.age = 33
    person2.salary = 79000
}

// =====================================================
// Finally, an example using Delegated Properties
// =====================================================

/**
 * We need to chanhe the previoous "obersable" class a litle bit, to match
 * the Kotlin conventions. so we create a new one here
 */

class ObservableProperty2 (var propValue: Int,
                           val changeSupport: PropertyChangeSupport) {

    operator fun getValue(p: Person3, prop: KProperty<*>): Int = propValue

    operator fun setValue(p: Person3, prop: KProperty<*>, newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }

}

class Person3(val name: String,
              age: Int,
              salary: Int): PropertyChangeAware() {
    var age     : Int by ObservableProperty2(age, changeSupport)
    var salary  : Int by ObservableProperty2(salary, changeSupport)
}

/**
 * We test the final example, with REAL Delegated Properties
 */
fun testingDelegateProps() {

    println("> Testing Delegated properties...")

    // we create the Person3 instance...
    val person3 : Person3 = Person3("David", 22, 90000)

    // We add a listener to any change in any property, so it prints out a message
    person3.addPropertyChangeListener(
            PropertyChangeListener {event -> println("Property ${event.propertyName} changed " +
                    "from ${event.oldValue} to ${event.newValue}")
            }
    )

    // Now we change some things, to trigger the listener...
    person3.age = 33
    person3.salary = 79000
}
/**
 * Main Function
 */
fun main(vararg args: String) {

    testWithoutDelegateProps()

    testingObservable()

    testingDelegateProps()

}