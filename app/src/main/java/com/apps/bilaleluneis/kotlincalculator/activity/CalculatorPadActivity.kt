package com.apps.bilaleluneis.kotlincalculator.activity

import android.app.Activity
import android.os.Bundle
import com.apps.bilaleluneis.kotlincalculator.R

/**
 * @author Bilal El Uneis
 * @since 12/07/2017
 * bilaleluneis@gmail.com
 */

class CalculatorPadActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_calculator_pad)
    }
}
