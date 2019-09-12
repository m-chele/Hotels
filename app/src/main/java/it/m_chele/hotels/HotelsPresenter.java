package it.m_chele.hotels;

import io.reactivex.disposables.Disposable;

class HotelsPresenter {
    private HotelsView hotelsView;
    private HotelsModel hotelsModel;
    private Disposable disposable;

    public HotelsPresenter(HotelsView view) {
        hotelsView = view;
        hotelsModel = new HotelsModel();
    }

    public void loadData() {
        if (null != hotelsView) {
            hotelsView.showLoading();
        }
        disposable = hotelsModel.get()
                .subscribe(hotels -> {
                            if (null != hotelsView) {
                                hotelsView.updateWith(hotels);
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
}
