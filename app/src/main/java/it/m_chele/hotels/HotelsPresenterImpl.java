package it.m_chele.hotels;

import java.util.Collections;
import java.util.List;

import io.reactivex.disposables.Disposable;
import it.m_chele.hotels.model.Hotels;
import it.m_chele.hotels.model.HotelsItem;

class HotelsPresenterImpl implements HotelsPresenter {
    private HotelsView hotelsView;
    private HotelsModel hotelsModel;
    private Disposable disposable;
    private List<HotelsItem> hotels;

    public HotelsPresenterImpl(HotelsView view, HotelsModel model) {
        hotelsView = view;
        hotelsModel = model;
    }

    @Override
    public void loadData() {
        if (null != hotelsView) {
            hotelsView.showLoading();
        }
        disposable = hotelsModel.get()
                .subscribe(result -> loadCompletedWith(result),
                        error -> loadCompletedWith());
    }

    private void loadCompletedWith() {
        if (null != hotelsView) {
            hotelsView.showError();
        }
    }

    private void loadCompletedWith(Hotels result) {
        if (null != hotelsView) {
            this.hotels = result.getHotels();
            hotelsView.refreshData();
        }
    }

    @Override
    public void onDestroy() {
        if (null != disposable && !disposable.isDisposed()) {
            disposable.dispose();
        }
        hotelsView = null;
    }

    @Override
    public HotelsItem hotelAt(int position) {
        return hotels.get(position);
    }

    @Override
    public int hotelsCount() {
        return hotels.size();
    }

    @Override
    public void onClickOnHotelAt(int position) {
        hotelsView.onHotelItemClick(position);
    }

    private boolean ascending;

    @Override
    public void onClickOnToggleStarsSorting() {
        if(hotels == null) return;

        ascending = !ascending;
        int inversionCoefficient = ascending ? 1 : -1;
        Collections.sort(hotels, (o1, o2) -> inversionCoefficient * (o1.getStars() - o2.getStars()));
        hotelsView.starsSortingCompleted(ascending);
        hotelsView.refreshData();
    }
}
