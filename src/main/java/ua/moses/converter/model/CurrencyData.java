package ua.moses.converter.model;

public class CurrencyData {
    private String id;
    private String currencyName;
    private String currencySymbol;

    CurrencyData(String id, String currencyName, String currencySymbol) {
        this.id = id;
        this.currencyName = currencyName;
        this.currencySymbol = currencySymbol;
    }

    @Override
    public String toString() {
        return "Валюта: " + id + ". Название: " + currencyName + ". Символ: " + currencySymbol;
    }
}
