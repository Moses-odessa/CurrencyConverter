package ua.moses.converter.model;

import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class CurrencyConverterApiClientTest {
    @Test
    public void getRateTest(){
        CurrencyConverterApiClient currencyConverterApiClient = CurrencyConverterApiClient.retrofit.create(CurrencyConverterApiClient.class);
        Call<Map<String,RateValue>> call = currencyConverterApiClient.getRate("UAH_USD");
        Map<String,RateValue> result = null;
        try {
            Response<Map<String,RateValue>> response = call.execute();
            result = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertNotNull(result);
        assertNotEquals(0, result.get("UAH_USD").getVal());
    }

}
