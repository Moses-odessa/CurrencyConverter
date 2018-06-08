package ua.moses.converter.controller;

public interface CommandInterface {
    String EXIT_COMMAND = "exit";
    String HELP_COMMAND = "help";
    String CONVERT_COMMAND = "help";
    String GREETING = "Добро пожаловать!";
    String PARTING = "До скорой встречи!";
    String UNKNOW_WARNING = "Неизвестная комманда!";
    String COMMAND_PROMPT =
            String.format("------------------------------------------------------------------\n" +
                    "Введите нужную комманду или %s для справки (или %s для выхода):", HELP_COMMAND, EXIT_COMMAND);

    void run(String... parameters);
    boolean check(String commandName);
}
