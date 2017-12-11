package com.apps.bilaleluneis.kotlincalculator.model

import org.junit.*
import org.junit.Assert.*

/**
 * @author Bilal El Uneis
 * @since 12/07/2017
 * bilaleluneis@gmail.com
 * @see CalculatorBrain
 */

class CalculatorBrainUnitTest {

    private var calculator = CalculatorBrain()

    @Before
    fun setupBeforeEachTest(){ calculator.set(operand = 0.0) }

    @After
    fun tearDownAfterEachTest() { }

    @Test
    fun recognizeOperations() {

        val add = calculator.get("+")
        val subtract = calculator.get("-")
        val multiply = calculator.get("x")
        val invalid = calculator.get("|")
        val sqroot = calculator.get("√")

        assertEquals(CalculatorBrain.Operations.ADD, add)
        assertEquals(CalculatorBrain.Operations.SUBTRACT, subtract)
        assertEquals(CalculatorBrain.Operations.MULTIPLY, multiply)
        assertEquals(CalculatorBrain.Operations.INVALID, invalid)
        assertEquals(CalculatorBrain.Operations.SQROOT, sqroot)

    }

    @Test
    fun performOperations() {

        calculator.perform("+",2.0,3.0)
        assertEquals(5.0, calculator.result, 0.0)

        calculator.perform("x",2.0,3.0)
        assertEquals(6.0, calculator.result, 0.0)

        calculator.perform("-",3.0,2.0)
        assertEquals(1.0, calculator.result, 0.0)

        calculator.perform("√",4.0)
        assertEquals(2.0,calculator.result,0.0)

    }

}