package org.example.service;

import org.example.models.Student;

import java.util.List;

public interface StudentManagement {

    Student create(String name, int age);
    Student save(Student student);
    Student find(int id);
    Student remove(int id);
    List<Student> findAll();
    Student edit(int id, String newName, int newAge);
}
