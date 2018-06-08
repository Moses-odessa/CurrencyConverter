package ua.moses.converter.controller.command;

import ua.moses.converter.controller.CommandInterface;
import ua.moses.converter.model.CurrencyConverter;

public class ConvertCommand implements CommandInterface {
    private CurrencyConverter currencyConverter;

    public ConvertCommand(CurrencyConverter currencyConverter) {
        this.currencyConverter = currencyConverter;
    }

    @Override
    public void run(String... parameters) {
        if (parameters.length >= 3) {
            double rate;
            //todo add parse exception
            double amount = Double.parseDouble(parameters[0]);
            String fromCurrency = parameters[1];
            String toCurrency = parameters[2];
            rate = currencyConverter.rate(fromCurrency, toCurrency);
            System.out.println(String.format(RESULT_CONVERTING_STRING, amount, fromCurrency, rate*amount, toCurrency, rate));
        } else {
            System.out.println(FAULT_PARAMETERS);
        }

    }

    @Override
    public boolean check(String commandName) {
        return commandName.equalsIgnoreCase(CONVERT_COMMAND);
    }
}
