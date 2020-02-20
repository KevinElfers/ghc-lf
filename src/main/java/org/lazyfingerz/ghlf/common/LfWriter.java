package org.lazyfingerz.ghlf.common;

import org.lazyfingerz.ghlf.model.LfResult;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class LfWriter {

    private LfScoreCalculator sc = new LfScoreCalculator();

    public void write(LfResult result, String filename) throws FileNotFoundException {
        StringBuilder content = new StringBuilder(result.getOutput().size() + "\n");
        for (Integer i : result.getOutput()) {
            content.append(i);
            content.append(" ");
        }
        content.deleteCharAt(content.length()-1);
        content.append("\n");

        int score = sc.getScore(result);
        try (PrintWriter out = new PrintWriter("results/" + score + "-" + filename+"-"+System.currentTimeMillis()+".txt")) {
            out.println(content.toString());
        }
    }
}
