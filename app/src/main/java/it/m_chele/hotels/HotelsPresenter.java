package it.m_chele.hotels;

import java.util.List;

import io.reactivex.disposables.Disposable;
import it.m_chele.hotels.model.HotelsItem;

class HotelsPresenter {
    private HotelsView hotelsView;
    private HotelsModel hotelsModel;
    private Disposable disposable;
    private List<HotelsItem> hotels;

    public HotelsPresenter(HotelsView view) {
        hotelsView = view;
        hotelsModel = new HotelsModel();
    }

    public void loadData() {
        if (null != hotelsView) {
            hotelsView.showLoading();
        }
        disposable = hotelsModel.get()
                .subscribe(result -> {
                            if (null != hotelsView) {
                                this.hotels = result.getHotels();
                                hotelsView.refreshData();
                            }
                        },
                        error -> {
                            if (null != hotelsView) {
                                hotelsView.showError(error.getMessage());
                            }
                        });
    }

    public void onDestroy() {
        if (null != disposable && !disposable.isDisposed()) {
            disposable.dispose();
        }
        hotelsView = null;
    }

    public HotelsItem hotelAt(int position) {
        return hotels.get(position);
    }

    public int hotelsCount() {
        return hotels.size();
    }

    public void onClickOnHotelAt(int position) {
        hotelsView.onHotelItemClick(position);
    }
}
