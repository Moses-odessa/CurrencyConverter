package ua.moses.converter.model;

import java.util.List;

public class CurrencyConverterApi implements CurrencyConverter {
    @Override
    public double convert(double amount, String fromCurrency, String toCurrency) {
        return 0;
    }

    @Override
    public List<CurrencyData> currencies() {
        return null;
    }
}
