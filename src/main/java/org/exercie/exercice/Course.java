package org.exercie.exercice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course {
    private int id;
    private String label;
    private int credit;
    private Teacher teacher;
}
