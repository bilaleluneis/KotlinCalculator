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

    enum class Operations(val operator: String, val operation: (Int,Int) -> Int) {

        ADD("+", {x, y -> x + y}),
        SUBTRACT("-", {x,y -> x - y})

    }

    fun getOperation(operator: String) : Operations? {

        return try{
            Operations.values().first{ it -> it.operator == operator}
        }catch(exception : NoSuchElementException){
            null
        }

    }

}