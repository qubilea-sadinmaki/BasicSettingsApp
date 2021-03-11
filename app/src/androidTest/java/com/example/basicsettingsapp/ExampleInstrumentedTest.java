package com.example.basicsettingsapp;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.supportsInputMethods;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.*;
import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.action.ViewActions.*;
import static org.hamcrest.Matchers.not;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest {

    @Rule
    public ActivityScenarioRule<SettingsActivity> activityActivityScenarioRule
            = new ActivityScenarioRule<>(SettingsActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.basicsettingsapp", appContext.getPackageName());

        onView(withId(R.id.download_incoming)).check(matches(isDisplayed()));
    }

    @Test
    public void testTest(){

        onView(withId(R.id.settings))
                .check(matches(isDisplayed()));

        onView(withText("Your signature"))
                .perform(click());

        onView(supportsInputMethods())
                .perform(clearText())
                .perform(typeText("My signature"));

        onView(withText("OK"))
                .perform(click())
                .check(doesNotExist());

        onView(withText("My signature"))
                .check(matches(isDisplayed()));

        onView(withText("Default reply action"))
                .perform(click());

        onView(withText("Reply to all"))
                .perform(click())
                .check(matches(isDisplayed()));

        onView(withText("Sync email periodically"))
                .perform(click())
                .check(matches(isDisplayed()));

        onView(withText("Download incoming attachments"))
                .perform(click())
                .check(matches(isDisplayed()));

    }
}