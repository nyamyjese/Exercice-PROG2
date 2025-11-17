package org.exercie.exercice;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Teacher extends User {
    private Speciality speciality;

    public Teacher(int id, String name, String firstName, Date birthday,
                   String email, String phone, Speciality speciality) {
        super(id, name, firstName, birthday, email, phone);
        this.speciality = speciality;
    }
}
