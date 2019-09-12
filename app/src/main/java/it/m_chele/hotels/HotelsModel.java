package it.m_chele.hotels;

import io.reactivex.Single;
import it.m_chele.hotels.model.Hotels;

interface HotelsModel {
    Single<Hotels> get();
}
