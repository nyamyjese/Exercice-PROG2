package org.exercie.exercice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradeManagerTest {

    private Student student1;
    private Student student2;
    private Teacher teacher1;
    private Course course1;
    private Exam exam1;
    private Exam exam2;
    private Grade grade1;
    private Grade grade2;
    private GradeManager gradeManager;

    @BeforeEach
    public void setup() {
        Tutor tutor1 = new Tutor(1, "Paul", "Martin", new Date(), "tutor1@mail.com", "123456", "Father");

        student1 = new Student(1, "John", "Doe", new Date(), "john@mail.com", "111111", "G1", tutor1);
        student2 = new Student(2, "Jane", "Doe", new Date(), "jane@mail.com", "222222", "G1", tutor1);

        teacher1 = new Teacher(1, "Alice", "Smith", new Date(), "alice@mail.com", "333333", Speciality.FRONTEND);

        course1 = new Course(1, "PROG1", 5, teacher1);

        exam1 = new Exam(1, "Exam1", course1, LocalDateTime.now(), 2);
        exam2 = new Exam(2, "Exam2", course1, LocalDateTime.now(), 3);

        grade1 = new Grade(student1, exam1, 10, "Initial");
        grade2 = new Grade(student1, exam2, 15, "Initial");

        gradeManager = new GradeManager(Arrays.asList(grade1, grade2));
    }

    @Test
    public void testGetExamGrade() {
        Instant now = Instant.now();
        double gradeExam1 = gradeManager.getExamGrade(exam1, student1, now);
        double gradeExam2 = gradeManager.getExamGrade(exam2, student1, now);

        assertEquals(10, gradeExam1, 0.01);
        assertEquals(15, gradeExam2, 0.01);
    }

    @Test
    public void testGetCourseGrade() {
        Instant now = Instant.now();
        double finalGrade = gradeManager.getCourseGrade(course1, student1, now);

        assertEquals(13, finalGrade, 0.01);
    }

    @Test
    public void testGradeHistory() throws InterruptedException {

        grade1.updateGrade(12, "Correction");
        Thread.sleep(1000);
        Instant t = Instant.now();

        double oldValue = grade1.getGradeAt(grade1.getGradeHistoryList().get(0).getDate());
        assertEquals(10, oldValue, 0.01);

        double currentValue = grade1.getGradeAt(t);
        assertEquals(12, currentValue, 0.01);
    }
}
