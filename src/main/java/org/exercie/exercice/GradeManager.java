package org.exercie.exercice;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class GradeManager {
    private List<Grade> grades;

    public GradeManager(List<Grade> grades) {
        this.grades = grades;
    }

    public double getExamGrade(Exam exam, Student student, Instant t) {
        return grades.stream()
                .filter(g -> g.getExam().equals(exam) && g.getStudent().equals(student))
                .map(g -> g.getGradeAt(t))
                .findFirst()
                .orElse(0.0);
    }

    public double getCourseGrade(Course course, Student student, Instant t) {
        List<Grade> courseGrades = grades.stream()
                .filter(g -> g.getExam().getCourse().equals(course) && g.getStudent().equals(student))
                .collect(Collectors.toList());

        double total = 0;
        int totalCoeff = 0;
        for (Grade g : courseGrades) {
            total += g.getGradeAt(t) * g.getExam().getCoefficient();
            totalCoeff += g.getExam().getCoefficient();
        }
        return totalCoeff == 0 ? 0 : total / totalCoeff;
    }
}
