package ua.moses.converter.model;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.Map;

public interface CurrencyConverterApiClient {
    @GET("convert/?compact=y")
    Call<Map<String, RateValue>> getRate(
            @Query("q") String pair);

    @GET("currencies")
    Call<Map<String, Map<String, CurrencyData>>> getList();


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://free.currencyconverterapi.com/api/v5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
