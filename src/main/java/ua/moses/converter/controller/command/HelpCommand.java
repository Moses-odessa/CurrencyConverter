package ua.moses.converter.controller.command;

import ua.moses.converter.controller.CommandInterface;

public class HelpCommand implements CommandInterface {
    @Override
    public void run(String... parameters) {
        System.out.println(HELP_INFO);
    }

    @Override
    public boolean check(String commandName) {
        return commandName.equalsIgnoreCase(HELP_COMMAND);
    }
}
