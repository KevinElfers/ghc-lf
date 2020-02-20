package org.lazyfingerz.ghlf.common;

import org.lazyfingerz.ghlf.model.LfResult;

import java.io.FileNotFoundException;

public class LfWriter {

  private LfScoreCalculator sc = new LfScoreCalculator();

  public void write(LfResult result, String filename) throws FileNotFoundException {
      ResultParser parser = new ResultParser(result);
    StringBuilder content = new StringBuilder();
//    ArrayList<Library> orderedLibraries = getOrderedLibraries(result);
//
//    content.append(
//        orderedLibraries.stream()
//            .map(library -> library.getId().toString())
//            .collect(joining(" "))
//    ).append("\n");
//
//    for (Integer i : result.getOutput()) {
//      content.append(i);
//      content.append(" ");
//    }
//    content.deleteCharAt(content.length() - 1);
//    content.append("\n");
//
//    int score = sc.getScore(result);
//    try (PrintWriter out = new PrintWriter("results/" + score + "-" + filename + "-" + System.currentTimeMillis() + ".txt")) {
//      out.println(content.toString());
//    }
  }
}
