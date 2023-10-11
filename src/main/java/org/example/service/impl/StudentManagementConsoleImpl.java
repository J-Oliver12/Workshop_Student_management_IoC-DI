package org.example.service.impl;

import org.example.data_access.StudentDao;
import org.example.models.Student;
import org.example.service.StudentManagement;
import org.example.util.UserInputService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "org.example")
public class StudentManagementConsoleImpl implements StudentManagement {

    private final UserInputService scannerService;
    private final StudentDao studentDao;
    private final List<Student> studentList = new ArrayList<>();

    public StudentManagementConsoleImpl(UserInputService scannerService, StudentDao studentDao) {
        this.scannerService = scannerService;
        this.studentDao = studentDao;
    }

    @Override
    public Student create(String name, int age) {
        System.out.println("Creating a new student:");

        Student newStudent = new Student(name, age);

        System.out.println("New student created with ID: " + newStudent.getId());

        studentList.add(newStudent);

        return newStudent;
    }

    @Override
    public Student save(Student student) {
        if (student.getId() == 0) {
            studentList.add(student);
        } else {
            Student existingStudent = find(student.getId());
            if (existingStudent != null) {
                studentList.remove(existingStudent);
                studentList.add(student);
            }
        }
        return student;
    }

    @Override
    public Student find(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                System.out.println("Student found:");
                System.out.println(student.toString());
                return student;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
        return null;
    }

    @Override
    public Student remove(int id) {
        System.out.println("Removing a student with ID: " + id);

        Student removedStudent = null;
        for (Student student : studentList) {
            if (student.getId() == id) {
                removedStudent = student;
                break;
            }
        }

        if (removedStudent != null) {
            studentList.remove(removedStudent);
            System.out.println("Student removed:");
            System.out.println(removedStudent.toString());
        } else {
            System.out.println("Student with ID " + id + " not found. No student removed.");
        }

        return removedStudent;
    }

    @Override
    public List<Student> findAll() {
        System.out.println("Finding all students:");

        if (!studentList.isEmpty()) {
            System.out.println("All Students:");
            for (Student student : studentList) {
                System.out.println(student.toString());
            }
        } else {
            System.out.println("No students found.");
        }

        return new ArrayList<>(studentList);
    }

    @Override
    public Student edit(int id, String newName, int newAge) {
        Student existingStudent = find(id);

        if (existingStudent != null) {
            System.out.println("Editing student with ID " + id + ":");
            System.out.println("Previous details: " + existingStudent.toString());

            // Update the student's name and age
            existingStudent.setName(newName);
            existingStudent.setAge(newAge);

            System.out.println("Updated student details: " + existingStudent.toString());

            return existingStudent;
        } else {
            System.out.println("Student with ID " + id + " not found.");
            return null;
        }
    }


}
