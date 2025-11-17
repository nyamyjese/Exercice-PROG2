package org.exercie.exercice;

import lombok.Data;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
public class Grade {
    private Student student;
    private Exam exam;
    private double value;
    private List<GradeHistory> gradeHistoryList = new ArrayList<>();

    public Grade(Student student, Exam exam, double value, String reason) {
        this.student = student;
        this.exam = exam;
        this.value = value;
        gradeHistoryList.add(new GradeHistory(value, reason, Instant.now()));
    }

    public void updateGrade(double newValue, String reason) {
        this.value = newValue;
        gradeHistoryList.add(new GradeHistory(newValue, reason, Instant.now()));
    }

    public double getGradeAt(Instant t) {
        double result = value;
        for (GradeHistory gh : gradeHistoryList) {
            if (!gh.getDate().isAfter(t)) {
                result = gh.getNewValue();
            }
        }
        return result;
    }
}
