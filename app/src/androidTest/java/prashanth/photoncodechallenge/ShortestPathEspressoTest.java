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
        // Type text and then press the button.
        onView(withId(R.id.userInput))
                .perform(clearText());
        onView(withId(R.id.userInput))
                .perform(typeText("8 4 1 3 2 6\n5 9 3 9 9 5\n3 4 a 2 8 6"), closeSoftKeyboard());
        onView(withId(R.id.submitBtn)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.errorLabel)).check(matches(withText("Only Integers are allowed")));
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
        onView(withId(R.id.pathOutputLabel)).check(matches(withText("3 4 5 1 1 5")));
    }
}
