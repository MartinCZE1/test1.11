package com.example.test111;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private String subjectName;
    private List<Integer> marks = new ArrayList<>();

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;

    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }
}
