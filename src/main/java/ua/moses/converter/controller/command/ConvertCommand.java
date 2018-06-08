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
        double rate;
        double amount;
        String fromCurrency;
        String toCurrency;

        if (parameters.length >= 3) {
            fromCurrency = parameters[1];
            toCurrency = parameters[2];
        } else if (parameters.length >= 2) {
            fromCurrency = DEFAULT_CURRENCY;
            toCurrency = parameters[1];
        } else {
            System.out.println(FAULT_PARAMETERS);
            return;
        }

        try {
            amount = Double.parseDouble(parameters[0]);
        }catch (NumberFormatException e){
            System.out.println(FAULT_PARAMETERS);
            return;
        }

        try {
            rate = currencyConverter.rate(fromCurrency, toCurrency);
            System.out.println(String.format(RESULT_CONVERTING_STRING, amount, fromCurrency, rate * amount, toCurrency, rate));
        } catch (RuntimeException e) {
            System.out.println(CONNECTION_ERROR + e.getLocalizedMessage());
        }

    }

    @Override
    public boolean check(String commandName) {
        return commandName.equalsIgnoreCase(CONVERT_COMMAND);
    }
}
