package org.exercie.exercice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String firstName;
    private Date birthday;
    private String email;
    private String phone;
}
