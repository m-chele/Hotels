package it.m_chele.hotels;

import java.util.List;

class HotelsPresenter {
    private HotelsView hotelsView;
    private HotelsModel hotelsModel;

    public HotelsPresenter(HotelsView view) {
        hotelsView = view;
        hotelsModel = new HotelsModel();
    }

    public void loadData() {
        // show loading
        hotelsView.showLoading();

        hotelsModel.get(new HotelsModel.OnFinishedListener() {
            @Override
            public void onSuccess(List<Hotel> hotelsList) {
                hotelsView.updateWith(hotelsList);
            }

            @Override
            public void onError(Throwable t) {
                hotelsView.showError(t.getMessage());

            }
        });
    }

    public void onDestroy() {
        hotelsView = null;
    }
}
