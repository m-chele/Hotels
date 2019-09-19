package it.m_chele.hotels;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import it.m_chele.hotels.model.Hotels;
import it.m_chele.hotels.network.ApiInterface;

import static it.m_chele.hotels.network.ApiClient.getClient;

public class HotelsModelImpl implements HotelsModel {

    @Inject
    public HotelsModelImpl() {
    }

    public Single<Hotels> get() {

        return getClient()
                .create(ApiInterface.class)
                .getHotels()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
