package com.apps.bilaleluneis.kotlincalculator.model

import org.junit.*
import org.junit.Assert.*

/**
 * @author Bilal El Uneis
 * @since 12/07/2017
 * bilaleluneis@gmail.com
 */

class CalculatorBrainUnitTest {

    private val calculatorBrainModel = CalculatorBrain()

    @Before
    fun setupBeforeEachTest(){

    }

    @After
    fun tearDownAfterEachTest() {

    }

    @Test
    fun recognizeOperations() {

        assertEquals(CalculatorBrain.Operations.ADD, calculatorBrainModel.getOperation("+"))

    }

}