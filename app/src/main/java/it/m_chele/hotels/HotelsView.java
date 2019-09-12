package it.m_chele.hotels;

interface HotelsView {
    void showLoading();

    void showError();

    void refreshData();

    void onHotelItemClick(int position);

    void starsSortingCompleted(boolean ascending);
}
