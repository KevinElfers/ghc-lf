package org.lazyfingerz.ghlf.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;

@Data
@AllArgsConstructor
public class LfProblemInstance {

    LinkedList<Integer> input;
}
