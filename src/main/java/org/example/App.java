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
 *
 */
public class App 
{
    public static void main( String[] args ) {

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

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Choose an option:");
            System.out.println("1. Create a student");
            System.out.println("2. Find a student");
            System.out.println("3. Remove a student");
            System.out.println("4. List all students");
            System.out.println("5. Edit a student");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the student's name: ");
                    String studentName = scanner.next();
                    System.out.println("Enter the student's age: ");
                    int studentAge = scanner.nextInt();

                    Student createdStudent = studentManagement.create(studentName, studentAge); // Store the created student
                    System.out.println("New student created with ID: " + createdStudent.getId());
                    break;
                case 2:
                    System.out.println("Enter the student's ID: ");
                    int studentId = scanner.nextInt(); // Provide the actual ID
                    studentManagement.find(studentId);
                    break;
                case 3:
                    System.out.println("Enter the student's ID to remove: ");
                    int removeId = scanner.nextInt();
                    studentManagement.remove(removeId);
                    break;
                case 4:
                    studentManagement.findAll();
                    break;
                case 5:
                    System.out.println("Enter the student's ID to edit: ");
                    int editId = scanner.nextInt();
                    System.out.println("Enter the new name: ");
                    String newName = scanner.next();
                    System.out.println("Enter the new age: ");
                    int newAge = scanner.nextInt();
                    studentManagement.edit(editId, newName, newAge);
                    break;
                case 6:
                    // Exit the loop
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }

        System.out.println("Exiting the application.");
        scanner.close();
    }
}







