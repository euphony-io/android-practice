package com.example.android_practice

import android.view.KeyEvent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class ChangeCounterBehaviorTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)

    val initCounter = 0

    /**
     * onView(withId(R.id.XXXX))
     *     .check(matches(withText("text"))
     */
    @Test
    fun testInitCounter() {
        // Check countTV text is 0
        onView(withId(R.id.countTV))
            .check(matches(withText(initCounter.toString())))
    }

    /**
     * onView(withId(R.id.XXXX))
     *     .perform(click())
     *     .check(matches(withText("text"))
     */
    @Test
    fun testIncrement() {
        // Click Add button
        onView(withId(R.id.add_button))
            .perform(click())
        // Check countTV text is (initCounter+1)
        onView(withId(R.id.countTV))
            .check(matches(withText((initCounter+1).toString())))
    }

    @Test
    fun testDecrement() {
        // Click Subtract button
        onView(withId(R.id.subtract_button))
            .perform(click())
        // Check countTV text is (initCounter-1)
        onView(withId(R.id.countTV))
            .check(matches(withText((initCounter-1).toString())))
    }

    /**
    pressKey(KeyEvent.KEYCODE_DEL)
    typeText
    closeSoftKeyboard()
     */
    val changedCounter = 5

    @Test
    fun testChangeCounter() {
        // Edit countTV text to "changedCounter"
        onView(withId(R.id.countTV))
            .perform(pressKey(KeyEvent.KEYCODE_DEL), typeText(changedCounter.toString()), closeSoftKeyboard())

        // Click apply button
        onView(withId(R.id.apply_button))
            .perform(click())

        // Click add button
        onView(withId(R.id.add_button))
            .perform(click())
        // Check countTV value (changedCounter+1)
        onView(withId(R.id.countTV))
            .check(matches(withText((changedCounter+1).toString())))
    }

    @Test
    fun testChangeCounterWithoutClickApplyButton() {
        // Edit countTV text to "changedCounter"
        onView(withId(R.id.countTV))
            .perform(pressKey(KeyEvent.KEYCODE_DEL), typeText(changedCounter.toString()), closeSoftKeyboard())
        // Click add button
        onView(withId(R.id.add_button))
            .perform(click())
        // Check countTV value (initCounter + 1)
        onView(withId(R.id.countTV))
            .check(matches(withText((initCounter+1).toString())))
    }
}