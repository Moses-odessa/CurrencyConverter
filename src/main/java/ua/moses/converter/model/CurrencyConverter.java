package ua.moses.converter.model;

import java.util.List;

public interface CurrencyConverter {
    double convert(double amount, String fromCurrency, String toCurrency) throws RuntimeException;
    double rate(String fromCurrency, String toCurrency) throws RuntimeException;
    List<CurrencyData> currencies();

}
