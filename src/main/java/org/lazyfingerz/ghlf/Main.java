package org.lazyfingerz.ghlf;

import org.lazyfingerz.ghlf.common.LfReader;
import org.lazyfingerz.ghlf.common.LfWriter;
import org.lazyfingerz.ghlf.model.LfProblemInstance;
import org.lazyfingerz.ghlf.model.LfResult;
import org.lazyfingerz.ghlf.processor.LfProcessor;

import java.io.IOException;

public class Main {

    private final static String A = "a_example.txt";
    private final static String B = "b_read_on.txt";
    private final static String C = "c_incunabula.txt";
    private final static String D = "d_tough_choices.txt";
    private final static String E = "e_so_many_books.txt";
    private final static String F = "f_libraries_of_the_world.txt";

    public static void main(String[] args) throws IOException {

        String filename = B;

        LfProblemInstance problemInstance = new LfReader().read("src/main/resources/" + filename);
        LfResult result = new LfProcessor().process(problemInstance);
        new LfWriter().write(result, filename);
    }

}
