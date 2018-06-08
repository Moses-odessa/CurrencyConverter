package ua.moses.converter.controller;

public class ExitCommand implements CommandInterface {
    @Override
    public void run(String... parameters) {
        if (parameters.length > 0){
            System.out.println(parameters[0]);
            System.exit(0);
        }

    }
}
