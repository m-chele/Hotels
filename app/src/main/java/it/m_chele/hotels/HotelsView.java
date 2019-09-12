package it.m_chele.hotels;

interface HotelsView {
    void showLoading();

    void showError(String message);

    void refreshData();

    void onHotelItemClick(int position);
}
