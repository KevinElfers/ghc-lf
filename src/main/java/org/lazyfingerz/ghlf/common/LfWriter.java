package org.lazyfingerz.ghlf.common;

import org.lazyfingerz.ghlf.model.LfResult;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class LfWriter {

  public void write(LfResult result, String filename) throws FileNotFoundException {
    ResultParser parser = new ResultParser(result);
    StringBuilder content = new StringBuilder();

    List<String> libraryIds = parser.parseUniqueOrderedLibraryIds();

    content.append(libraryIds.size()).append("\n");
    content.append(libraryIds.stream().collect(joining(" "))).append("\n");

    try (PrintWriter out = new PrintWriter("results/" + filename + ".txt")) {
      out.println(content.toString());
    }
  }
}
