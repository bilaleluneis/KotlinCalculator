package com.apps.bilaleluneis.kotlincalculator.model

/**
 * @author Bilal El Uneis
 * @since September 2018
 * bilaleluneis@gmail.com
 */

/**
 * used sealed class so I can simulate Enum but at same time
 * get the advantage of creating instance of subclasses at runtime
 * with different values and functions passed as parameters.
 *
 * sealed classes are abstract and final, you can't create instance
 * nor can you inherit them outside the file they are in.
 *
 * the subclasses are also closed by default , so you cant inherit them
 * from the outside either, but you can create instances of them.
 */

sealed class Operation

class Const(private val value: Double) : Operation() {
    operator fun invoke() = this.value
}

class Unary(private val operation: (Double) -> Double) : Operation() {
    operator fun invoke(value: Double) = this.operation(value)
}

class Binary(private val operation: (Double, Double) -> Double) : Operation() {
    operator fun invoke(first: Double, second: Double) = this.operation(first, second)
}
