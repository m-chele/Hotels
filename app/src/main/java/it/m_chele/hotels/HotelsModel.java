package it.m_chele.hotels;

import it.m_chele.hotels.model.Hotels;
import it.m_chele.hotels.network.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static it.m_chele.hotels.network.ApiClient.getClient;

class HotelsModel {

    public void get(final OnFinishedListener onFinishedListener) {


        ApiInterface apiInterface = getClient().create(ApiInterface.class);
        apiInterface.getHotels().enqueue(new Callback<Hotels>() {
            @Override
            public void onResponse(Call<Hotels> call, Response<Hotels> response) {
                onFinishedListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Hotels> call, Throwable t) {
                onFinishedListener.onError(t);
            }
        });
    }


    // TODO: rxJava
    interface OnFinishedListener {

        void onSuccess(Hotels hotelsList);

        void onError(Throwable t);
    }


}
