package ua.moses.converter.controller.command;

import ua.moses.converter.controller.CommandInterface;
import ua.moses.converter.model.CurrencyConverter;
import ua.moses.converter.model.CurrencyConverterApi;
import ua.moses.converter.model.CurrencyData;

import java.util.List;

public class ListCommand implements CommandInterface {
    private CurrencyConverter currencyConverter;

    public ListCommand(CurrencyConverter currencyConverter) {
        this.currencyConverter = currencyConverter;
    }

    @Override
    public void run(String... parameters) {
        List<CurrencyData> currencyList = currencyConverter.currencies();
        for (CurrencyData currency: currencyList){
            System.out.println(currency);
        }
    }

    @Override
    public boolean check(String commandName) {
        return commandName.equalsIgnoreCase(LIST_COMMAND);
    }
}
