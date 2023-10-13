package org.example.util.impl;

import org.example.util.UserInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ScannerInputService implements UserInputService {

    private final Scanner scanner;

    @Autowired
    public ScannerInputService(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }



    @Override
    public int getInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            System.out.print(prompt);
            scanner.next(); // Consume invalid input
        }
        int result = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return result;
    }



}
