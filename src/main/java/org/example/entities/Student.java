package org.example.entities;

public class Student {
    private int studentId;
    private String name;
    private String group;

    public Student(int studentId, String name, String group) {
        this.studentId = studentId;
        this.name = name;
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}