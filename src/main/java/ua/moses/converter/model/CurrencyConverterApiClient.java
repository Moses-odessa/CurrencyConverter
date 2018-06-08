package ua.moses.converter.model;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.Map;

public interface CurrencyConverterApiClient {
    @GET("?compact=y")
    Call<Map<String,RateValue>> getRate(
            @Query("q") String pair);


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://free.currencyconverterapi.com/api/v5/convert/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
