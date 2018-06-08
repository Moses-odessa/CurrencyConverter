package ua.moses.converter.controller.command;

import ua.moses.converter.controller.CommandInterface;

public class UnknowCommand implements CommandInterface {
    @Override
    public void run(String... parameters) {
        System.out.println(UNKNOW_WARNING);
    }

    @Override
    public boolean check(String commandName) {
        return true;
    }
}
