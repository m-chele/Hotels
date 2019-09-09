package it.m_chele.hotels;

import java.util.List;

interface HotelsView {
    void showLoading();

    void showError();

    void updateWith(List<Hotel> hotelsList);
}
