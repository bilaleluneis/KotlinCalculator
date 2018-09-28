package com.apps.bilaleluneis.kotlincalculator.model

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import kotlin.math.sqrt

/**
 * @author Bilal El Uneis
 * @since Sep 2018
 * bilaleluneis@gmail.com
 * @see Operation
 */

class OperationUnitTest {

    @Before
    fun setupBeforeEachTest(){} // for now don't see need to do anything here

    @After
    fun tearDownAfterEachTest() {} // nothing to implement here for now either

    @Test
    fun const(){
        val pi = 3.14159
        val operation: Operation = Const(pi)
        val const = operation as Const
        val result = const()
        assertEquals(pi, result, 0.0)
    }

    @Test
    fun unary(){
        val operation: Operation = Unary {x -> x * x}
        val powerOfTwo = operation as Unary
        val result = powerOfTwo(2.0)
        assertEquals(4.0, result, 0.0)
    }

    @Test
    fun binary(){
        val operation: Operation = Binary {x, y -> x + y}
        val add = operation as Binary
        val result = add(2.0, 3.0)
        assertEquals(5.0, result, 0.0)
    }

    @Test
    fun operations(){
        val mapOfOperations: HashMap<String, Operation> = hashMapOf(
                "π" to Const(3.14159),
                "√" to Unary {x -> sqrt(x)},
                "+" to Binary {x, y-> x + y},
                "-" to Binary {x, y-> x - y})

        for((symbol, operation) in mapOfOperations){

            val result = when(operation){
                is Const  -> operation()
                is Unary  -> operation(4.0)
                is Binary -> operation(3.0, 4.0)
            }

            if(symbol == "π"){ assertEquals(3.14159, result, 0.0) }
            if(symbol == "√"){ assertEquals(2.0, result, 0.0) }
            if(symbol == "+"){ assertEquals(7.0, result, 0.0) }

        }
    }


}