package org.exercie.exercice;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Tutor extends User {
    private String linkWithStudent;

    public Tutor(int id, String name, String firstName, Date birthday,
                 String email, String phone, String linkWithStudent) {
        super(id, name, firstName, birthday, email, phone);
        this.linkWithStudent = linkWithStudent;
    }
}
