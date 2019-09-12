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
        viewStub = new HotelsViewTest();
        HotelsModel modelStub = () -> succesfullLoad();

        presenter = new HotelsPresenterImpl(viewStub, modelStub);

    }

    @Test
    public void informs_view_of_loading_status() {
        presenter.loadData();

        assertTrue(viewStub.showLoadingCalled);
    }

    @Test
    public void informs_view_of_refreshing_data_after_loading() {
        presenter.loadData();

        assertTrue(viewStub.refreshDataCalled);
    }

    private Single<Hotels> succesfullLoad() {
        return Single.create(emitter -> emitter.onSuccess(new Hotels()));
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
