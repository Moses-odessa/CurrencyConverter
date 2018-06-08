package ua.moses.converter.controller.command;

import ua.moses.converter.controller.CommandInterface;

public class ExitCommand implements CommandInterface {
    @Override
    public void run(String... parameters) {
        System.out.println(PARTING);
        System.exit(0);

    }

    @Override
    public boolean check(String commandName) {
        return commandName.equalsIgnoreCase(EXIT_COMMAND);
    }
}
