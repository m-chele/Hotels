package it.m_chele.hotels.network;

import it.m_chele.hotels.model.Hotels;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    //    https://services.lastminute.com/mobile/stubs/hotels
    @GET("hotels")
    Call<Hotels> getHotels();

}
