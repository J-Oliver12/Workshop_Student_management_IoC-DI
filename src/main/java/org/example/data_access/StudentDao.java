package org.example.data_access;

import org.example.models.Student;

import java.util.List;

public interface StudentDao {
    Student save(Student student);
    Student find(int id);
    Student remove(int id);
    List<Student> findAll();
    Student edit(Student student);
}
