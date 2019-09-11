package it.m_chele.hotels;

import it.m_chele.hotels.model.Hotels;

class HotelsPresenter implements HotelsModel.OnFinishedListener {
    private HotelsView hotelsView;
    private HotelsModel hotelsModel;

    public HotelsPresenter(HotelsView view) {
        hotelsView = view;
        hotelsModel = new HotelsModel();
    }

    public void loadData() {
        if (null != hotelsView) {
            hotelsView.showLoading();
        }
        hotelsModel.get(this);
    }

    public void onDestroy() {
        hotelsView = null;
    }

    @Override
    public void onSuccess(Hotels hotelsList) {
        if (null != hotelsView) {
            hotelsView.updateWith(hotelsList);
        }
    }

    @Override
    public void onError(Throwable t) {
        if (null != hotelsView) {
            hotelsView.showError(t.getMessage());
        }
    }
}
