package org.example.data_access.impl;

import org.example.data_access.StudentDao;
import org.example.models.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDaoListImpl implements StudentDao {

    private final List<Student> students = new ArrayList<>();
    private int nextId = 1;


    @Override
    public Student save(Student student) {
            students.add(student);
        return student;
    }


    @Override
    public Student find(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null; // Student not found
    }

    @Override
    public Student remove(int id) {
        Student studentToRemove = null;
        for (Student student : students) {
            if (student.getId() == id) {
                studentToRemove = student;
                break;
            }
        }
        if (studentToRemove != null) {
            students.remove(studentToRemove);
        }
        return studentToRemove;
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public Student edit(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == student.getId()) {
                students.set(i, student);
                return student;
            }
        }
        return null; // Student not found, no changes made
    }


}
