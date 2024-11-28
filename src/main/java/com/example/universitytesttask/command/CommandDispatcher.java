package com.example.universitytesttask.command;

import com.example.universitytesttask.exception.UniversityEntityNotFound;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandDispatcher {
    private final Map<String, Command> commandMap;

    @Autowired
    public CommandDispatcher(List<Command> commands) {
        this.commandMap = commands.stream()
                .collect(Collectors.toMap(
                        Command::getInputRegex,
                        command -> command
                ));
    }

    public void dispatch(String input) {
        for (Map.Entry<String, Command> entry : commandMap.entrySet()) {
            if (input.matches(entry.getKey())) {
                try {
                    entry.getValue().execute(input);
                } catch (UniversityEntityNotFound ex) {
                    System.out.println(ex.getMessage());
                }
                return;
            }
        }
        System.out.println("Command not recognized!");
    }
}
