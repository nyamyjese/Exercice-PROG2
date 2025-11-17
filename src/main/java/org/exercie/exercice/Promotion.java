package org.exercie.exercice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Promotion {
    private List<String> groups;
}
