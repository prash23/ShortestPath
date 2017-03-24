package prashanth.photoncodechallenge;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Prashanth on 3/23/2017.
 */

public class ShortestPathEspressoTest {
    @Rule
    public ActivityTestRule<ShortestPathActivity> mActivityRule =
            new ActivityTestRule<>(ShortestPathActivity.class);

    @Test
    public void ensureTextChangesWork() {
        // Type text and then press the button.
        onView(withId(R.id.userInput))
                .perform(clearText());
        onView(withId(R.id.userInput))
                .perform(typeText("51 1\n50 2"), closeSoftKeyboard());
        onView(withId(R.id.submitBtn)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.totalCostLabel)).check(matches(withText("50")));
    }

    @Test
    public void ensureValidationsWork() {
        /*
        * Validation 1
        */
        onView(withId(R.id.userInput))
                .perform(clearText());
        onView(withId(R.id.userInput))
                .perform(typeText("8 4 1 3 2 6\n5 9 3 9 9 5\n3 4 a 2 8 6"), closeSoftKeyboard());
        onView(withId(R.id.submitBtn)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.errorLabel)).check(matches(withText("Only Integers are allowed")));

        /*
        * Validation 2
        */

        onView(withId(R.id.userInput))
                .perform(clearText());
        onView(withId(R.id.userInput))
                .perform(typeText("51 51\n0 51\n51 51\n5 5"), closeSoftKeyboard());
        onView(withId(R.id.submitBtn)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.pathOutputLabel)).check(matches(withText("[4 4]")));

         /*
        * Validation 3
        */

        onView(withId(R.id.userInput))
                .perform(clearText());
        onView(withId(R.id.userInput))
                .perform(typeText("51 51 51\n0 51 51\n51 51 51\n5 5 51"), closeSoftKeyboard());
        onView(withId(R.id.submitBtn)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.pathOutputLabel)).check(matches(withText("[4 4]")));

        /*
         Validation 4
        */

        onView(withId(R.id.userInput))
                .perform(clearText());
        onView(withId(R.id.userInput))
                .perform(typeText("5\n8\n5\n3\n5"), closeSoftKeyboard());
        onView(withId(R.id.submitBtn)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.pathOutputLabel)).check(matches(withText("[4]")));

        /*
         Validation 5
        */

        onView(withId(R.id.userInput))
                .perform(clearText());
        onView(withId(R.id.userInput))
                .perform(typeText("3 4 1 2 8 6\n6 1 8 2 7 4\n5 9 3 9 9 5\n8 4 1 3 2 6\n3 7 2 8 6 4"), closeSoftKeyboard());
        onView(withId(R.id.submitBtn)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.pathOutputLabel)).check(matches(withText("[1 2 3 4 4 5]")));

         /*
         Validation 6
        */

        onView(withId(R.id.userInput))
                .perform(clearText());
        onView(withId(R.id.userInput))
                .perform(typeText("3 4 1 2 8 6\n6 1 8 2 7 4\n5 9 3 9 9 5\n8 4 1 3 2 6\n3 7 2 1 2 3"), closeSoftKeyboard());
        onView(withId(R.id.submitBtn)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.pathOutputLabel)).check(matches(withText("[1 2 1 5 5 5]")));

        /*
         Validation 7
        */

        onView(withId(R.id.userInput))
                .perform(clearText());
        onView(withId(R.id.userInput))
                .perform(typeText("19 10 19 10 19\n21 23 20 19 12\n20 12 20 11 10"), closeSoftKeyboard());
        onView(withId(R.id.submitBtn)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.pathOutputLabel)).check(matches(withText("[1 1 1]")));

        /*
         Validation 8
        */

        onView(withId(R.id.userInput))
                .perform(clearText());
        onView(withId(R.id.userInput))
                .perform(typeText("5 8 5 3 5"), closeSoftKeyboard());
        onView(withId(R.id.submitBtn)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.pathOutputLabel)).check(matches(withText("[1 1 1 1 1]")));



         /*
         Validation 9
        */

        onView(withId(R.id.userInput))
                .perform(clearText());
        onView(withId(R.id.userInput))
                .perform(typeText("69 10 19 10 19\n51 23 20 19 12\n60 12 20 11 10"), closeSoftKeyboard());
        onView(withId(R.id.submitBtn)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.pathOutputLabel)).check(matches(withText("[]")));


        /*
         Validation 10
        */

        onView(withId(R.id.userInput))
                .perform(clearText());
        onView(withId(R.id.userInput))
                .perform(typeText("1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2"), closeSoftKeyboard());
        onView(withId(R.id.submitBtn)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.pathOutputLabel)).check(matches(withText("[1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1]")));
    }

    @Test
    public void ensureFinalPathIsCorrect() {
        // Type text and then press the button.
        onView(withId(R.id.userInput))
                .perform(clearText());
        onView(withId(R.id.userInput))
                .perform(typeText("8 4 1 3 2 6\n5 9 3 9 9 5\n3 4 1 2 8 6\n6 1 8 2 7 4\n3 7 2 8 6 4"), closeSoftKeyboard());
        onView(withId(R.id.submitBtn)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.pathOutputLabel)).check(matches(withText("[3 4 5 1 1 5]")));
    }
}
