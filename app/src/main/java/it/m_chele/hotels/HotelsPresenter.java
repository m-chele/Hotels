package it.m_chele.hotels;

import it.m_chele.hotels.model.HotelsItem;

interface HotelsPresenter {
    void loadData();

    void onDestroy();

    HotelsItem hotelAt(int position);

    int hotelsCount();

    void onClickOnHotelAt(int position);

    void onClickOnToggleStarsSorting();
}
