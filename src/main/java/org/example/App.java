package org.example;

import org.example.config.AppConfig;
import org.example.config.ComponentScanConfig;
import org.example.models.Student;
import org.example.service.StudentManagement;
import org.example.util.UserInputService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        // Part 1
        /*AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);*/


        // Part 2
        /*AnnotationConfigApplicationContext context =
                //new AnnotationConfigApplicationContext(AppConfig.class);  // by using new AppConfig class
                new AnnotationConfigApplicationContext(ComponentScanConfig.class); // by adding method to already existing configuration class
        UserInputService userInputService =context.getBean(UserInputService.class);*/


        // Part 3
        /*AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        // Get the StudentManagement bean
        StudentManagement studentManagement = context.getBean(StudentManagement.class);

        // Check if the StudentManagement bean is not null
        if (studentManagement != null) {
            System.out.println("Application started successfully.");
        } else {
            System.out.println("Application failed to start.");
        }
        context.close();*/


        ApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentManagement studentManagement = context.getBean(StudentManagement.class);
        UserInputService userInputService = context.getBean(UserInputService.class);

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Choose an option:");
            System.out.println("1. Create a student");
            System.out.println("2. Find a student");
            System.out.println("3. Remove a student");
            System.out.println("4. List all students");
            System.out.println("5. Edit a student");
            System.out.println("6. Exit");

            int choice = userInputService.getInt("Choose a valid option:");

            switch (choice) {
                case 1:
                    String studentName = userInputService.getString("Enter the student's name: ");
                    int studentAge = userInputService.getInt("Enter the student's age: ");

                    Student createdStudent = studentManagement.create(studentName, studentAge);
                    System.out.println("New student created with ID: " + createdStudent.getId());
                    break;
                case 2:
                    int studentId = userInputService.getInt("Enter the student's ID: ");
                    Student foundStudent = studentManagement.find(studentId);
                    if (foundStudent != null) {
                        System.out.println("Student found with ID: " + foundStudent.getId());
                    }
                    break;
                case 3:
                    int removeId = userInputService.getInt("Enter the student's ID to remove: ");
                    Student removedStudent = studentManagement.remove(removeId);
                    if (removedStudent != null) {
                        System.out.println("Student removed with ID: " + removedStudent.getId());
                    }
                    break;
                case 4:
                    List<Student> students = studentManagement.findAll();
                    if (!students.isEmpty()) {
                        System.out.println("No students found.");
                    }
                    break;
                case 5:
                    int editId = userInputService.getInt("Enter the student's ID to edit: ");
                    String newName = userInputService.getString("Enter the new name: ");
                    int newAge = userInputService.getInt("Enter the new age: ");
                    Student editedStudent = studentManagement.edit(editId, newName, newAge);
                    if (editedStudent != null) {
                        System.out.println("Student edited with ID: " + editedStudent.getId());
                    }
                    break;
                case 6:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }

        System.out.println("Exiting the application.");
    }
}







