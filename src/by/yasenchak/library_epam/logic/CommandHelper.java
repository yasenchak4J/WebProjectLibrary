package by.yasenchak.library_epam.logic;


import by.yasenchak.library_epam.logic.impl.GetAllBookCommand;
import by.yasenchak.library_epam.logic.impl.RegistrationCommand;
import by.yasenchak.library_epam.logic.impl.SignInCommand;

import java.util.HashMap;
import java.util.Map;

public final class CommandHelper {
    private static CommandHelper instance = new CommandHelper();
    private Map<String, Command> commands = new HashMap<>();

    private CommandHelper(){
        commands.put("registration", new RegistrationCommand());
        commands.put("signin", new SignInCommand());
        commands.put("getAllBook", new GetAllBookCommand());
    }

    public static CommandHelper getInstance(){
        return instance;
    }

    public Command getCommand(String commandName){
        Command command = null;
        if(commandName != null){
            command = commands.get(commandName);
        }
        return command;
    }
}
