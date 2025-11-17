package org.exercie.exercice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Exam {
    private int id;
    private String title;
    private Course course;
    private LocalDateTime dateTime;
    private int coefficient;
}
