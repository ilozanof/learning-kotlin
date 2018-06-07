package com.ilozanof.kotlin.learning.overloading

/**
 * Eamples of overloading operators and how to use conventions.
 */


data class Point(val x: Int, val y: Int) {
    /**
     * this functions overloads a operator, that¡s why we use the "operator" keyword.
     * The operator overloaded in this caseis the "+" operator, since we use the name
     * "plus" for the function, which following the Kotlin conventions, overloads the
     * "plus" operator
     */
    operator fun plus(other: Point): Point = Point(x + other.x, y + other.y)

    /**
     * We override the "toString" function
     */
    override fun toString() = "Point[$x,$y]"

}

/**
 * A class Rectangle, with 2 different constructors
 */
class Rectangle {
    val upperLeft: Point
    val bottomright: Point

    constructor (_upperLeft: Point, _bottomright: Point) {
        upperLeft   = _upperLeft
        bottomright = _bottomright
    }

    constructor(x1: Int, y1: Int, x2: Int, y2: Int) {
        upperLeft   = Point(x1, y1)
        bottomright = Point(x2, y2)
    }
}

/**
 * We override the "in" operator
 */

operator fun Rectangle.contains(p: Point) = (
            (p.x in upperLeft.x until bottomright.x) &&
            (p.y in upperLeft.y until bottomright.y)
        )

/**
 * Now, we'll use an extension function to overload another operator, the "-" operator
 */
operator fun Point.minus(other: Point) = Point(x - other.x, y - other.y)

/**
 * No we are overriding the index operators, so we can access the [x,y] coordenates
 * by using the syntax "x = p[0]" or "y = p[1]"
 */
operator fun Point.get(index: Int): Int {
    return when(index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("Invalid coordinate. Only 0 or 1 are supported")
    } // when...
}

/**
 * Main function
 */
fun main(vararg args: String) {

    var point: Point = Point(1,1)
    point = point + Point(20,20)
    println(point)

    point = point - Point(1,5)
    println(point)

    println("Coordinate X: ${point[0]}, Coordinate Y: ${point[1]}")

    val rec: Rectangle = Rectangle(0,0, 100,100)
    println("Is th Point inside the Rectqngle? ${point in rec}")

}