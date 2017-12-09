package com.apps.bilaleluneis.kotlincalculator.model

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
    enum class Operations(val operator: String, val operation: (Double?, Double?) -> Double) {

        INVALID("",{ _, _ -> 0.0}),
        ADD("+", { x, y -> (x ?: 0.0) + (y ?: 0.0) }),
        SUBTRACT("-", { x, y -> (x ?: 0.0) - (y ?: 0.0) }),
        MULTIPLY("x", { x, y -> (x ?: 0.0) * (y ?: 0.0) }),

    }

    private var accumlator : Double?

    // setter is private , but getter is public
    var result: Double private set
                                get() = accumlator ?: 0.0

    init {
        accumlator = null
        result = 0.0
    }


    fun getOperation(operator: String) : Operations {

        return try{
            Operations.values().first{ it -> it.operator == operator}
        }catch(exception : NoSuchElementException){
           Operations.INVALID
        }

    }

}