package it.m_chele.hotels;

import android.content.Intent;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import it.m_chele.hotels.model.HotelsItem;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4ClassRunner.class)
public class HotelsListActivityPresenterInteractionTest {

    @Rule
    public ActivityTestRule<HotelsListActivity> rule =
            new ActivityTestRule<>(HotelsListActivity.class, true, false);
    private HotelsPresenterStub presenterStub;

    @Before
    public void setUp() {
        Intent startIntent = new Intent();
        rule.launchActivity(startIntent);

        HotelsListActivity activity = rule.getActivity();
        presenterStub = new HotelsPresenterStub();
        activity.setPresenter(presenterStub);
    }

    @Test
    public void clicks_on_fab_performs_sorting_by_stars() {
        onView(withId(R.id.fab)).perform(click());

        assertTrue(presenterStub.onClickOnToggleStarsSortingCalled);
    }

    private class HotelsPresenterStub implements HotelsPresenter {
        public boolean onClickOnToggleStarsSortingCalled;

        public HotelsPresenterStub() {
        }

        @Override
        public void loadData() {
        }

        @Override
        public void onDestroy() {
        }

        @Override
        public HotelsItem hotelAt(int position) {
            return null;
        }

        @Override
        public int hotelsCount() {
            return 0;
        }

        @Override
        public void onClickOnHotelAt(int position) {

        }

        @Override
        public void onClickOnToggleStarsSorting() {
            onClickOnToggleStarsSortingCalled = true;
        }
    }
}
