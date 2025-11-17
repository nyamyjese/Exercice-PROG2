package org.exercie.exercice;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Student extends User {
    private String group;
    private Tutor tutor;

    public Student(int id, String name, String firstName, Date birthday,
                   String email, String phone, String group, Tutor tutor) {
        super(id, name, firstName, birthday, email, phone);
        this.group = group;
        this.tutor = tutor;
    }
}
