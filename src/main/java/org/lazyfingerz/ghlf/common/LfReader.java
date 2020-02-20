package org.lazyfingerz.ghlf.common;

import org.lazyfingerz.ghlf.model.LfProblemInstance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LfReader {

    public LfProblemInstance read(String filename) throws IOException {
        LinkedList<Integer> input = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            int lineCounter = 0;
            for (String line; (line = br.readLine()) != null; ) {
                if (lineCounter > 0) {
                    input.add(parseLine(line, lineCounter-1));
                }
                lineCounter++;
            }
        }
        return new LfProblemInstance(input);
    }

    private Integer parseLine(String line, int lineIndex) {
        List<String> elements = new LinkedList(Arrays.asList((line.split(" "))));

        //add logic below
        return Integer.valueOf(elements.get(0));
    }

}
