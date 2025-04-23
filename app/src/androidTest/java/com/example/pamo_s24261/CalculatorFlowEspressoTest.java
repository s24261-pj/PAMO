package com.example.pamo_s24261;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import static org.hamcrest.Matchers.containsString;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CalculatorFlowEspressoTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void calculateBmi_displaysCorrectResult() throws InterruptedException {
        Thread.sleep(3500);

        onView(withId(R.id.btnBMI))
                .perform(click());

        onView(withId(R.id.etWeight))
                .perform(typeText("70"), closeSoftKeyboard());
        onView(withId(R.id.etHeight))
                .perform(typeText("175"), closeSoftKeyboard());

        onView(withId(R.id.btnCalculate))
                .perform(click());

        onView(withId(R.id.tvResult))
                .check(matches(withText(containsString("BMI: 22.86"))))
                .check(matches(withText(containsString("Status: optimum"))));
    }
}
