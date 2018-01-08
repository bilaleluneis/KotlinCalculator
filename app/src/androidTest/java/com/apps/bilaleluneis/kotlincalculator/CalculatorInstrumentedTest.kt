package com.apps.bilaleluneis.kotlincalculator

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.apps.bilaleluneis.kotlincalculator.activity.CalculatorPadActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * @author Bilal El Uneis
 * @since Jan 2018
 * bilaleluneis@gmail.com
 */

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CalculatorInstrumentedTest {

    @Rule @JvmField
    val calculatorPadActivityTestRule =  ActivityTestRule(CalculatorPadActivity::class.java)

    @Test
    fun validateDisplayInitialState() {
        onView(withId(R.id.display)).check(matches(withText("0.0")))
    }

    @Test
    fun digitsOnlyClicks() {

        val buttonValue1 = onView(withId(R.id.one))
        val buttonValue3 = onView(withId(R.id.three))
        val buttonValue8 = onView(withId(R.id.eight))

        buttonValue1.perform(click())
        buttonValue3.perform(click())
        buttonValue8.perform(click())

        onView(withId(R.id.display)).check(matches(withText("138")))

    }


}
