package it.m_chele.hotels;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import it.m_chele.hotels.model.Hotels;
import it.m_chele.hotels.network.ApiInterface;

import static it.m_chele.hotels.network.ApiClient.getClient;

class HotelsModelImpl implements HotelsModel {

    public Single<Hotels> get() {

        return getClient()
                .create(ApiInterface.class)
                .getHotels()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
