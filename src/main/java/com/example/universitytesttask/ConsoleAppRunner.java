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
        printCommands();
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

    private void printCommands() {
        System.out.println("University App is running. Enter your commands");
        System.out.println("Allowed commands:");
        System.out.println("1) Who is head of department {department_name}");
        System.out.println("2) Show {department_name} statistics");
        System.out.println("3) Show the average salary for the department {department_name}");
        System.out.println("4) Show count of employee for {department_name}");
        System.out.println("5) Global search by {template}");
        System.out.println("6) \"exit\" to close");
    }
}
