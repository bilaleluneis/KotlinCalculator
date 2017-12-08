package com.apps.bilaleluneis.kotlincalculator.model

import org.junit.*
import org.junit.Assert.*

/**
 * @author Bilal El Uneis
 * @since 12/07/2017
 * bilaleluneis@gmail.com
 */

class CalculatorBrainUnitTest {

    private var calculatorBrainModel : CalculatorBrain? = null

    @Before
    fun setupBeforeEachTest(){

        calculatorBrainModel = CalculatorBrain()
    }

    @After
    fun tearDownAfterEachTest() {
        calculatorBrainModel =  null
    }

    @Test
    fun recognizeOperations() {

        val add = calculatorBrainModel?.getOperation("+")
        val subtract = calculatorBrainModel?.getOperation("-")

        assertEquals(CalculatorBrain.Operations.ADD, add)
        assertEquals(CalculatorBrain.Operations.SUBTRACT, subtract)

    }

}