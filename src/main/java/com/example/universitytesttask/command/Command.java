package com.example.universitytesttask.command;

public interface Command {
    void execute(String input);

    String getInputRegex();

    default String extractParamFromInput(String regex, String input) {
        return input.replaceFirst(regex, "$1");
    }
}
