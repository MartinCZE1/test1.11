package com.example.test111;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private ChoiceBox<String> studentInput;

    @FXML
    private ChoiceBox<String> subjectInput;

    @FXML
    private Button submitButton;

    @FXML
    private TextArea output;

    @FXML
    private TextField inputMarks;

    List<Student> students = new ArrayList<>();

    @FXML
    protected void onSubmitButtonClick() {
        int selectedStudent = studentInput.getSelectionModel().getSelectedIndex();
        int selectedSubject = subjectInput.getSelectionModel().getSelectedIndex();

        Student student = students.get(selectedStudent);
        Subject subject = student.getSubjects().get(selectedSubject);

        List<Integer> list = new ArrayList<>();
        String[] marks = inputMarks.getText().split(",");

        for (int i = 0; i < marks.length; i++) {
            int value = Integer.parseInt(marks[i]);
            list.add(value);
        }
        System.out.println(list);
        double average = MathUtils.average(list);

        output.setText("Průměr: " + average);
        subject.setMarks(list);
    }

    public void load() {
        System.out.println("load");
        int selectedStudent = studentInput.getSelectionModel().getSelectedIndex();
        int selectedSubject = subjectInput.getSelectionModel().getSelectedIndex();

        if (selectedStudent > 0 && selectedSubject > 0) {
            List<Integer> marks = students.get(selectedStudent).getSubjects().get(selectedSubject).getMarks();
            String chars = "";
            for (int i = 0; i < marks.size(); i++) {
                chars = marks + ",";
            }
            inputMarks.setText(chars);
        } else {
            inputMarks.setText("");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Subject subjectOne = new Subject("Matematika");
        Subject subjectTwo = new Subject("Čeština");
        Subject subjectThree = new Subject("Sítě");

        List<Subject> subjects = new ArrayList<>();
        subjects.add(subjectOne);
        subjects.add(subjectTwo);
        subjects.add(subjectThree);

        students.add(new Student("Vojtěch", "Vlček", List.of(new Subject("Matematika"), new Subject("Čeština"), new Subject("Sítě"))));
        students.add(new Student("Ouyi", "Chen", List.of(new Subject("Matematika"), new Subject("Čeština"), new Subject("Sítě"))));
        students.add(new Student("Pavel", "Mík", List.of(new Subject("Matematika"), new Subject("Čeština"), new Subject("Sítě"))));
        students.add(new Student("Filip", "Picek", List.of(new Subject("Matematika"), new Subject("Čeština"), new Subject("Sítě"))));
        students.add(new Student("Štěpán", "Tomsa", List.of(new Subject("Matematika"), new Subject("Čeština"), new Subject("Sítě"))));


        for (int i = 0; i < students.size(); i++) {
            studentInput.getItems().add(students.get(i).getNameAndSurname());
        }

        subjectInput.getItems().addAll(subjectOne.getSubjectName());
        subjectInput.getItems().add(subjectTwo.getSubjectName());
        subjectInput.getItems().add(subjectThree.getSubjectName());
    }
}