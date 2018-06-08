package ua.moses.converter.model;

import java.util.Arrays;
import java.util.List;

public class CurrencyConverterApi implements CurrencyConverter {
    @Override
    public double convert(double amount, String fromCurrency, String toCurrency) {
        return amount * rate(fromCurrency, toCurrency);
    }

    @Override
    public double rate(String fromCurrency, String toCurrency) {
        return 1;
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
