package ua.moses.converter.model;

import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CurrencyConverterApi implements CurrencyConverter {
    @Override
    public double convert(double amount, String fromCurrency, String toCurrency) {
        return amount * rate(fromCurrency, toCurrency);
    }

    @Override
    public double rate(String fromCurrency, String toCurrency) {
        CurrencyConverterApiClient currencyConverterApiClient = CurrencyConverterApiClient.retrofit.create(CurrencyConverterApiClient.class);
        Call<Map<String,RateValue>> call = currencyConverterApiClient.getRate(fromCurrency + "_" + toCurrency);
        try {
            Response<Map<String,RateValue>> response = call.execute();
            Map<String,RateValue> body = response.body();
            RateValue rate = body.get(fromCurrency + "_" + toCurrency);
            return rate.getVal();
        } catch (IOException e) {
            //
            return 0;
        }

    }

    @Override
    public List<CurrencyData> currencies() {
        //todo receive currencies from api
        return Arrays.asList(new CurrencyData("USD", "Американский доллар", "$"),
                new CurrencyData("UAH", "Ураинская гривна", "₴"),
                new CurrencyData("EUR", "Евро", "€"),
                new CurrencyData("GBP", "Британский фунт", "£"));
    }
}
