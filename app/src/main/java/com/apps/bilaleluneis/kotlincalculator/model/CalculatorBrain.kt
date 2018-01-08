package com.apps.bilaleluneis.kotlincalculator.model

import java.lang.Math.*

/**
 * @author Bilal El Uneis
 * @since 12/07/2017
 * bilaleluneis@gmail.com
 */

/**
 *  Re-implementation of Calculator from IOS 10 class by Standford University.
 *  But using Kotlin instead !
 */

class CalculatorBrain {

    /**
     * changed operation parameter to take Optionals so I can pass nulls
     * and allow this method signature to work unary, binary and constant
     * operations.
     */
    enum class Operations(val operator : String, val operation : (Double?, Double?) -> Double) {

        INVALID("", { _, _ -> 0.0}),
        ADD("+", { x, y -> (x ?: 0.0) + (y ?: 0.0) }),
        SUBTRACT("-", { x, y -> (x ?: 0.0) - (y ?: 0.0) }),
        MULTIPLY("x", { x, y -> (x ?: 0.0) * (y ?: 0.0) }),
        SQROOT("√", {x,_ -> sqrt(x ?: 0.0)})

    }

    private var accumulator: Double = 0.0

    // setter is private , but getter is public
    var result: Double = 0.0
        private set
        get() = accumulator


    fun get(operator: String) : Operations {

        return try{
            Operations.values().first{ it -> it.operator == operator}
        }catch(exception : NoSuchElementException){
           Operations.INVALID
        }

    }

    fun perform(operator: String, operand1: Double = 0.0, operand2: Double = 0.0){

        val calculationToPerform = get(operator)
        if(calculationToPerform != Operations.INVALID){
            accumulator = calculationToPerform.operation(operand1, operand2)
        }

    }

}