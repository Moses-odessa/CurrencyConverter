package ua.moses.converter.model;

import retrofit2.Call;
import retrofit2.Response;
import ua.moses.converter.controller.CommandInterface;

import java.io.IOException;
import java.util.*;

public class CurrencyConverterApi implements CurrencyConverter {
    @Override
    public double convert(double amount, String fromCurrency, String toCurrency) {
        return amount * rate(fromCurrency, toCurrency);
    }

    @Override
    public double rate(String fromCurrency, String toCurrency) throws RuntimeException {
        CurrencyConverterApiClient currencyConverterApiClient = CurrencyConverterApiClient.retrofit.create(CurrencyConverterApiClient.class);
        Call<Map<String,RateValue>> call = currencyConverterApiClient.getRate(fromCurrency + "_" + toCurrency);
        try {
            Response<Map<String,RateValue>> response = call.execute();
            Map<String,RateValue> body = response.body();
            RateValue rate = body.get(fromCurrency + "_" + toCurrency);
            return rate.getVal();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        } catch (NullPointerException e) {
            throw new RuntimeException("CURRENCY PAIR NOT FOUND");
        }

    }

    @Override
    public List<CurrencyData> currencies() throws RuntimeException{
        CurrencyConverterApiClient currencyConverterApiClient = CurrencyConverterApiClient.retrofit.create(CurrencyConverterApiClient.class);
        Call<Map<String, Map<String, CurrencyData>>> call = currencyConverterApiClient.getList();
        try {
            Response<Map<String, Map<String, CurrencyData>>> response = call.execute();
            Map<String, Map<String, CurrencyData>> body = response.body();
            Map<String, CurrencyData> currencyDataMap = body.get("results");
            List<CurrencyData> list = new ArrayList<>(currencyDataMap.values());
            list.sort((o1, o2) -> o1.getId().compareToIgnoreCase(o2.getId()));
            return list;
        } catch (IOException|NullPointerException e) {
            throw new RuntimeException(e.getMessage());
        }
        //return Arrays.asList(new CurrencyData("USD", "Американский доллар", "$"),
        //        new CurrencyData("UAH", "Ураинская гривна", "₴"),
        //        new CurrencyData("EUR", "Евро", "€"),
        //        new CurrencyData("GBP", "Британский фунт", "£"));
    }
}
