package org.lazyfingerz.ghlf.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LfProblemInstance {

    int books;
    int libraries;
    int days;

    LinkedList<Integer> input;
}
