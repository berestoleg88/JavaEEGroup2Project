package org.example.dao;

import org.example.entities.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleStudentDAO implements StudentDAO {

    @Override
    public void createStudent(String name, String group) {
        try (Connection connection = OracleDAOFactory.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO STUDENTS(STUDENT_ID, STUDENT_FIO, STUDENT_GROUP) VALUES (NULL, ?, ?)");) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, group);
            preparedStatement.execute();
            System.out.println("Student was created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudentName(int id, String name) {

    }

    @Override
    public void removeStudent(int id) {

    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        try (Connection connection = OracleDAOFactory.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM STUDENTS ORDER BY STUDENT_FIO");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                studentList.add(parseStudent(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }


    private Student parseStudent(ResultSet resultSet) {
        Student student = null;
        try {
            int student_id = resultSet.getInt("STUDENT_ID");
            String student_name = resultSet.getString("STUDENT_FIO");
            String student_group = resultSet.getString("STUDENT_GROUP");
            student = new Student(student_id, student_name, student_group);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

}
