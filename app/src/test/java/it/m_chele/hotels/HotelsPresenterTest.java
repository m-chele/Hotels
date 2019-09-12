package it.m_chele.hotels;

import org.junit.Before;
import org.junit.Test;

import io.reactivex.Single;
import it.m_chele.hotels.model.Hotels;

import static junit.framework.TestCase.assertTrue;

public class HotelsPresenterTest {

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

        assertTrue(viewStub.showErrorCalled);
    }

    private void withLoadingSuccess() {
        viewStub = new HotelsViewTest();
        HotelsModel modelStub = () -> Single.create(emitter -> emitter.onSuccess(new Hotels()));

        presenter = new HotelsPresenterImpl(viewStub, modelStub);
    }

    private void withLoadingError() {
        viewStub = new HotelsViewTest();
        HotelsModel modelStub = () -> Single.create(emitter -> emitter.onError(new Exception()));

        presenter = new HotelsPresenterImpl(viewStub, modelStub);
    }


    private class HotelsViewTest implements HotelsView {

        public boolean showErrorCalled;
        public boolean refreshDataCalled;
        public boolean showLoadingCalled;


        @Override
        public void showLoading() {
            showLoadingCalled = true;
        }

        @Override
        public void showError() {
            showErrorCalled = true;
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
