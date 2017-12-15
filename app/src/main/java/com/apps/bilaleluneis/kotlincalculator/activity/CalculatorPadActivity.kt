package com.apps.bilaleluneis.kotlincalculator.activity

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
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

        // TODO: need to look at bellow and see if I can combine into one
        // as of now I am doing filter and map twice on calculatorButtons !
        calculatorButtons
                .filter { it -> Regex("[0-9]").matches(input= it.text) }
                .map { it.setOnClickListener{ onDigitClicked(it as Button) } }

        calculatorButtons
                .filter { it -> !Regex("[0-9]").matches(input= it.text) }
                .map { it.setOnClickListener{ onOperationClicked(it as Button) } }

    }

    /**
     * initializer for calculatorButtons, which is lazy init and
     * will only be called the first time calculatorButtons is accessed
     * and will only get called once.
     */
    private fun initCalculatorButtons() : Array<Button> {

        Log.d(loggerTag, "InitCalculatorButtons()")

        val parentLayout = findViewById<LinearLayout>(R.id.linear_layout)
        var childLayoutList = emptyArray<LinearLayout>()
        var buttons : Array<Button> = emptyArray()

        //TODO: there has to be better way to go through children of parent layout and buttons
        // but I am still learning this stuff, so i am sure in time i will come back and
        //refactor this code
       (0 until parentLayout.childCount)
               .filter { index -> parentLayout.getChildAt(index) is LinearLayout }
               .map {index -> childLayoutList += parentLayout.getChildAt(index) as LinearLayout}

        for(childLayout in childLayoutList) {

            (0 until childLayout.childCount)
                    .filter { index -> childLayout.getChildAt(index) is Button }
                    .map { index -> buttons += childLayout.getChildAt(index) as Button }
        }


       return buttons

    }

    private fun onDigitClicked(button: Button) {

        Log.d(loggerTag,"Digit ${button.text} clicked !")

    }

    private fun onOperationClicked(button: Button) {

        Log.d(loggerTag,"Operation ${button.text} clicked !")

    }

}
