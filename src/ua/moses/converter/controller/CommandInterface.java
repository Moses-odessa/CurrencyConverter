package ua.moses.converter.controller;

public interface CommandInterface {
    String EXIT_COMMAND = "exit";
    String HELP_COMMAND = "help";
    String CONVERT_COMMAND = "convert";
    String LIST_COMMAND = "list";
    String GREETING = "Добро пожаловать!";
    String PARTING = "До скорой встречи!";
    String UNKNOW_WARNING = "Неизвестная комманда!";
    String HELP_INFO = String.format("Доступные комманды:\n" +
            "%s AMOUNT FROM_CURRENCY TO_CURRENCY \n" +
            "\t- конвертирует валюту на сумму AMOUNT из валюты FROM_CURRENCY в валюту TO_CURRENCY\n" +
            "%s - список доступных валют\n" +
            "%s - вывод этой справки\n" +
            "%s - завершение программы", CONVERT_COMMAND, LIST_COMMAND, HELP_COMMAND, EXIT_COMMAND);

    String COMMAND_PROMPT =
            String.format("------------------------------------------------------------------\n" +
                    "Введите нужную комманду или %s для справки (или %s для выхода):", HELP_COMMAND, EXIT_COMMAND);

    void run(String... parameters);
    boolean check(String commandName);
}
