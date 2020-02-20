package org.lazyfingerz.ghlf.common;

import org.lazyfingerz.ghlf.model.LfResult;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.joining;

public class LfWriter {

  public void write(LfResult result, String filename) throws FileNotFoundException {
    ResultParser parser = new ResultParser(result);
    StringBuilder content = new StringBuilder();

    List<Integer> libraryIds = parser.parseUniqueOrderedLibraryIds();

    content.append(libraryIds.size()).append("\n");

    libraryIds.forEach(libraryId -> {
      List<Integer> orderedBooks = parser.getOrderedBooks(libraryId);
      content.append(libraryId +" "+ orderedBooks.size()).append("\n");
      content.append(orderedBooks.stream().map(Objects::toString).collect(joining(" "))).append("\n");
    });

    try (PrintWriter out = new PrintWriter("results/" + filename + ".txt")) {
      out.println(content.toString());
    }
  }
}
