package org.example.util;

import org.springframework.context.annotation.Bean;

import java.util.Scanner;

public interface UserInputService {
    String getString(String prompt);
    int getInt(String prompt);

}
