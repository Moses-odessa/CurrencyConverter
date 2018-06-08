package ua.moses.converter.model;

public class CurrencyData {
    private String id;
    private String currencyName;
    private String currencySymbol;

    public CurrencyData(String id, String currencyName, String currencySymbol) {
        this.id = id;
        this.currencyName = currencyName;
        this.currencySymbol = currencySymbol;
    }

    @Override
    public String toString() {
        return "CurrencyData{" +
                "id='" + id + '\'' +
                ", currencyName='" + currencyName + '\'' +
                ", currencySymbol='" + currencySymbol + '\'' +
                '}';
    }
}
