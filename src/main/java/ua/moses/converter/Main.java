package ua.moses.converter;

import ua.moses.converter.controller.CommandController;
import ua.moses.converter.model.CurrencyConverterApi;

public class Main {

    public static void main(String[] args) {
        CommandController controller = new CommandController(new CurrencyConverterApi());
        controller.run();
    }
}
