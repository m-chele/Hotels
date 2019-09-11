package it.m_chele.hotels;

import it.m_chele.hotels.model.Hotels;

class HotelsPresenter {
    private HotelsView hotelsView;
    private HotelsModel hotelsModel;

    public HotelsPresenter(HotelsView view) {
        hotelsView = view;
        hotelsModel = new HotelsModel();
    }

    public void loadData() {
        hotelsView.showLoading();

        hotelsModel.get(new HotelsModel.OnFinishedListener() {
            @Override
            public void onSuccess(Hotels hotelsList) {
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
