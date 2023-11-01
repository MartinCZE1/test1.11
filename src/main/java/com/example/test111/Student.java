package com.example.test111;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String surname;
    private List<Subject> subjects = new ArrayList<>();

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Student(String name, String surname, List<Subject> subjects) {
        this.name = name;
        this.surname = surname;
        this.subjects = subjects;
    }

    public String getNameAndSurname() {
        return name + " " + surname;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}
