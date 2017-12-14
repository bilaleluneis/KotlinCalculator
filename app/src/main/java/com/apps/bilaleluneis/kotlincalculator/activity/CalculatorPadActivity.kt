package com.apps.bilaleluneis.kotlincalculator.activity

import android.app.Activity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.util.Log
import android.widget.Button
import com.apps.bilaleluneis.kotlincalculator.R

/**
 * @author Bilal El Uneis
 * @since 12/07/2017
 * bilaleluneis@gmail.com
 */

class CalculatorPadActivity : Activity() {

    private val loggerTag = "CalculatorPadActivity"
    private val calculatorButtons by lazy{ initCalculatorButtons() }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator_pad)
        calculatorButtons.forEach { it.setOnClickListener { onDigitClicked(it as Button) } }

    }

    private fun initCalculatorButtons() : Array<Button>{

        Log.d(loggerTag, "InitCalculatorButtons()")
        val layout = findViewById<ConstraintLayout>(R.id.constrain_layout)
        var buttons : Array<Button> = emptyArray()

        (0 until layout.childCount)
                .filter { index -> layout.getChildAt(index) is Button }
                .map { index ->  buttons += layout.getChildAt(index) as Button}

       return buttons

    }

    private fun onDigitClicked(button: Button){

        Log.d(loggerTag,"button ${button.text} clicked !")

    }

}
