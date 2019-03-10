package com.example.testcasesusingespresso;

import android.os.SystemClock;
import android.widget.DatePicker;

import com.example.testcasesusingespresso.activity.SplashActivity;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import androidx.test.espresso.contrib.PickerActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestStudentForm {

    //Use delay for the api call according to the amount of data needs to be fetched----
    private static final long DELAY_MAX_EXTRA = 5000;
    protected static final long DELAY_MIN = 1000;
    protected static final long DELAY_MEDIUM = 1000;

    //Students Login details-----
    private static final String ENROLLMENT_NO = "000011112222";
    private static final String PASSWORD = "ABC123.";

    //Students Details----
    protected static final String FULL_NAME = "HEATHER JANE ";
    protected static final String MOBILE_NO = "9997872060";
    protected static final String EMAIL_ID = "heatherjane10@gmail.com";
    protected static final String MOTHER_NAME = "JENNIFER JANE";
    protected static final String FATHER_NAME = "RACHEL JANE";
    protected static final String AADHAR_NO = "209470511028";
    protected static final String STREET = "5 GROVE STREET";
    protected static final String AREA = "UNIT 3";
    protected static final String CITY = "SOUTHAMPTON";
    protected static final String POSTAL_CODE = "720461";

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(SplashActivity.class);

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testNavigateMainScreen() {
        testLoginScreen();
        testStudentDetails();
    }

    private void testLoginScreen() {
        SystemClock.sleep(DELAY_MAX_EXTRA);
        SystemClock.sleep(DELAY_MAX_EXTRA);
        //For the editText use the below code that follows:-
        onView(ViewMatchers.withId(R.id.enrolment)).perform(typeText(ENROLLMENT_NO), closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.password)).perform(typeText(PASSWORD), closeSoftKeyboard());

        //For the Button use the below code that follows:-
        onView(ViewMatchers.withId(R.id.buttonLogin)).perform(click());
        SystemClock.sleep(DELAY_MIN);
    }

    private void testStudentDetails() {
        //For spinner use the below code that follows:-
        onView(withId(R.id.title_spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)))).atPosition(1).perform(click());
        SystemClock.sleep(DELAY_MIN);

        onView(ViewMatchers.withId(R.id.fullName)).perform(typeText(FULL_NAME), closeSoftKeyboard());

        //For DatePicker use the below code that follows:-
        onView(withId(R.id.dateOfBirth)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(1993, 12, 10));//.perform(setDate(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH));
        SystemClock.sleep(DELAY_MIN);
        //below code will press the ok button after the date is been set-----
        onView(withId(android.R.id.button1)).perform(click());
        SystemClock.sleep(DELAY_MIN);

        onView(withId(R.id.gender_spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)))).atPosition(1).perform(click());
        SystemClock.sleep(DELAY_MIN);

        onView(withId(R.id.yearOfPassing)).perform(click());
        onData(allOf(is(instanceOf(String.class)))).atPosition(1).perform(click());
        SystemClock.sleep(DELAY_MIN);

        onView(ViewMatchers.withId(R.id.phone)).perform(typeText(MOBILE_NO), closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.email)).perform(typeText(EMAIL_ID), closeSoftKeyboard());
        //For radioButton use the below code that follows:-
        onView(withId(R.id.radio_unmarried)).check(matches(isDisplayed()));
        onView(withId(R.id.radio_unmarried)).perform(click());
        SystemClock.sleep(DELAY_MIN);

        //For switch use the below code that follows:-
        onView(withId(R.id.scNationality)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.scNationality)).perform(click());

        onView(ViewMatchers.withId(R.id.motherName)).perform(typeText(MOTHER_NAME), closeSoftKeyboard());

        //Use scrollview wherever required to make widgets in the view--------
        onView(withId(R.id.scrollView)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.scrollView)).perform(swipeUp());

        onView(ViewMatchers.withId(R.id.fatherName)).perform(typeText(FATHER_NAME), closeSoftKeyboard());

        onView(withId(R.id.scrollView)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.scrollView)).perform(swipeUp());

        onView(ViewMatchers.withId(R.id.aadharCardNumber)).perform(typeText(AADHAR_NO), closeSoftKeyboard());

        SystemClock.sleep(DELAY_MEDIUM);
        onView(withId(R.id.scrollView)).perform(swipeUp());
        SystemClock.sleep(DELAY_MIN);

        onView(ViewMatchers.withId(R.id.street)).perform(typeText(STREET), closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.area)).perform(typeText(AREA), closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.city)).perform(typeText(CITY), closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.postal)).perform(typeText(POSTAL_CODE), closeSoftKeyboard());
        SystemClock.sleep(DELAY_MEDIUM);

        //For checkBox use the below code that follows:-
        onView(withId(R.id.check_declaration)).check(matches(isDisplayed()));
        onView(withId(R.id.check_declaration)).perform(click());
        SystemClock.sleep(DELAY_MIN);

        onView(ViewMatchers.withId(R.id.buttonNext)).perform(click());
    }
}
