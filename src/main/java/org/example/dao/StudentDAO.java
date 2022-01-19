package org.example.dao;

import org.example.entities.Student;

import java.util.List;

public interface StudentDAO {
    void createStudent(String name, String group);
    void updateStudentName(int id, String name);
    void removeStudent(int id);
    List<Student> getAllStudents();
}
