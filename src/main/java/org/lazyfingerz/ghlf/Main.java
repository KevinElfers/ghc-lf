package org.lazyfingerz.ghlf;

import org.lazyfingerz.ghlf.common.LfReader;
import org.lazyfingerz.ghlf.common.LfWriter;
import org.lazyfingerz.ghlf.model.LfProblemInstance;
import org.lazyfingerz.ghlf.model.LfResult;
import org.lazyfingerz.ghlf.processor.LfProcessor;

import java.io.IOException;

public class Main {

    private final static String A = "src/main/resources/a_example.txt";
    private final static String B = "src/main/resources/b_read_on.txt";
    private final static String C = "src/main/resources/c_incunabula.txt";
    private final static String D = "src/main/resources/d_tough_choices.txt";
    private final static String E = "src/main/resources/e_so_many_books.txt";
    private final static String F = "src/main/resources/f_libraries_of_the_world.txt";

    public static void main(String[] args) throws IOException {

        String filename = A;

        LfProblemInstance problemInstance = new LfReader().read(filename);
        LfResult result = new LfProcessor().process(problemInstance);
        new LfWriter().write(result, filename);
    }

}
