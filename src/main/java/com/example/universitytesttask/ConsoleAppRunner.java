package com.example.universitytesttask;

import com.example.universitytesttask.command.CommandDispatcher;
import java.util.Scanner;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsoleAppRunner implements CommandLineRunner {
    private final Scanner scanner = new Scanner(System.in);
    private final CommandDispatcher commandDispatcher;

    @Override
    public void run(String... args) {
        System.out.println("Console App is running. Enter your commands:");
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Exiting application...");
                break;
            }

            commandDispatcher.dispatch(input);
        }
    }
}
