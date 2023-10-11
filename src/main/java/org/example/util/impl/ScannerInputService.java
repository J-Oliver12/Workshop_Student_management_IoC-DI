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
        return scanner.nextInt();
    }



}
