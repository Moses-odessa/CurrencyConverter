package ua.moses.converter.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CurrencyConverterApi implements CurrencyConverter {
    @Override
    public double convert(double amount, String fromCurrency, String toCurrency) {
        return 0;
    }

    @Override
    public List<CurrencyData> currencies() {
        return Arrays.asList(new CurrencyData("USD", "Американский доллар", "$"),
                new CurrencyData("UAH", "Ураинская гривна", "₴"),
                new CurrencyData("EUR", "Евро", "€"),
                new CurrencyData("GBP", "Британский фунт", "£"));
    }
}
