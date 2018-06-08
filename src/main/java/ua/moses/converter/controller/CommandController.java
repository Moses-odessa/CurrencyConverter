package ua.moses.converter.controller;

import ua.moses.converter.controller.command.ExitCommand;
import ua.moses.converter.controller.command.HelpCommand;
import ua.moses.converter.controller.command.ListCommand;
import ua.moses.converter.controller.command.UnknowCommand;
import ua.moses.converter.model.CurrencyConverter;

import java.util.Arrays;
import java.util.Scanner;

public class CommandController {
    private CurrencyConverter currencyConverter;
    private CommandInterface[] commands;

    public CommandController(CurrencyConverter currencyConverter) {
        this.currencyConverter = currencyConverter;
        commands = new CommandInterface[]{
                new ExitCommand(),
                new HelpCommand(),
                new ListCommand(currencyConverter),
                new UnknowCommand()   //necessarily in last place
        };
    }

    public void run(){
        System.out.println(CommandInterface.GREETING);
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println(CommandInterface.COMMAND_PROMPT);
            String[] commandString = scanner.nextLine().split(" ");
            String commandName;
            String[] commandParameters = new String[0];
            commandName = commandString[0];
            if (commandString.length > 1) {
                commandParameters = Arrays.copyOfRange(commandString, 1, commandString.length);
            }

            for (CommandInterface command: commands) {
                if (command.check(commandName)){
                    command.run(commandParameters);
                    break;
                }
            }

        }

    }
}
