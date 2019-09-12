package it.m_chele.hotels;

import org.junit.Before;
import org.junit.Test;

import io.reactivex.Single;
import it.m_chele.hotels.model.Hotels;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class HotelsPresenterTest {


    public static final String EXCEPTION_TEST_MESSAGE = "Exception test message";
    private HotelsPresenter presenter;
    private HotelsViewTest viewStub;

    @Before
    public void setUp() {
    }

    @Test
    public void informs_view_of_loading_status() {

        withLoadingSuccess();

        presenter.loadData();

        assertTrue(viewStub.showLoadingCalled);
    }

    @Test
    public void informs_view_of_refreshing_data_after_loading() {
        withLoadingSuccess();

        presenter.loadData();

        assertTrue(viewStub.refreshDataCalled);
    }

    @Test
    public void informs_view_of_loading_error() {
        withLoadingError();

        presenter.loadData();

        assertEquals(EXCEPTION_TEST_MESSAGE, viewStub.showErrorCalledWithMessage);
    }

    private void withLoadingSuccess() {
        viewStub = new HotelsViewTest();
        HotelsModel modelStub = () -> Single.create(emitter -> emitter.onSuccess(new Hotels()));

        presenter = new HotelsPresenterImpl(viewStub, modelStub);
    }

    private void withLoadingError() {
        viewStub = new HotelsViewTest();
        HotelsModel modelStub = () -> Single.create(emitter -> emitter.onError(new Exception(EXCEPTION_TEST_MESSAGE)));

        presenter = new HotelsPresenterImpl(viewStub, modelStub);
    }


    private class HotelsViewTest implements HotelsView {

        public String showErrorCalledWithMessage;
        public boolean refreshDataCalled;
        public boolean showLoadingCalled;


        @Override
        public void showLoading() {
            showLoadingCalled = true;
        }

        @Override
        public void showError(String message) {
            showErrorCalledWithMessage = message;
        }

        @Override
        public void refreshData() {
            refreshDataCalled = true;
        }

        @Override
        public void onHotelItemClick(int position) {
        }

        @Override
        public void starsSortingCompleted(boolean ascending) {

        }
    }
}
