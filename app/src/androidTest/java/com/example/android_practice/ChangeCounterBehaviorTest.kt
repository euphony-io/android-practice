package com.example.android_practice

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
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
    }

    /**
     * onView(withId(R.id.XXXX))
     *     .perform(click())
     *     .check(matches(withText("text"))
     */
    @Test
    fun testIncrement() {
        // Click Add button
        // Check countTV text is (initCounter+1)
    }

    @Test
    fun testDecrement() {
        // Click Add button
        // Check countTV text is (initCounter-1)
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
        // Click apply button
        // Click add button
        // Check countTV value (changedCounter+1)
    }

    @Test
    fun testChangeCounterWithoutClickApplyButton() {
        // Edit countTV text to "changedCounter"
        // Click add button
        // Check countTV value (initCounter + 1)
    }
}