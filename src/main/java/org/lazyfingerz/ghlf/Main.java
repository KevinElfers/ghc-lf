package org.lazyfingerz.ghlf;

import org.lazyfingerz.ghlf.common.LfReader;
import org.lazyfingerz.ghlf.common.LfWriter;
import org.lazyfingerz.ghlf.model.LfProblemInstance;
import org.lazyfingerz.ghlf.model.LfResult;
import org.lazyfingerz.ghlf.processor.LfProcessor;

import java.io.IOException;

public class Main {

    private final static String A = "a.txt";
    private final static String B = "b.txt";
    private final static String C = "c.txt";
    private final static String D = "d.txt";
    private final static String E = "e.txt";
    private final static String F = "f.txt";

    public static void main(String[] args) throws IOException {

        String filename = A;

        LfProblemInstance problemInstance = new LfReader().read(filename);
        LfResult result = new LfProcessor().process(problemInstance);
        new LfWriter().write(result, filename);
    }

}
