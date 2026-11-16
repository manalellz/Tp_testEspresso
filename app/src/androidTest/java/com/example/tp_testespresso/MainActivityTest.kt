package com.example.tp_testespresso

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val activityRule =
        ActivityScenarioRule(MainActivity::class.java)
    @Test
    fun testButtonChangesText() {

        onView(withId(R.id.textView))
            .check(matches(withText("Hello World!")))

        onView(withId(R.id.button))
            .perform(click())

        onView(withId(R.id.textView))
            .check(matches(withText("Button Clicked!")))
    }

    @Test
    fun testMultipleClicks() {
        onView(withId(R.id.button))
            .perform(click(), click(), click())

        onView(withId(R.id.textView))
            .check(matches(withText("Button Clicked!")))
    }
}
