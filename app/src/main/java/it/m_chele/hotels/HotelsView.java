package it.m_chele.hotels;

import it.m_chele.hotels.model.Hotels;

interface HotelsView {
    void showLoading();

    void showError(String message);

    void updateWith(Hotels hotelsList);
}
