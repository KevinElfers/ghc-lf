package org.lazyfingerz.ghlf.common;

import org.lazyfingerz.ghlf.model.Book;
import org.lazyfingerz.ghlf.model.BookPackage;
import org.lazyfingerz.ghlf.model.LfResult;
import org.lazyfingerz.ghlf.model.Library;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ResultParser {

  LfResult result;

  public ResultParser(LfResult result) {
    this.result = result;
  }

  public List<Integer> parseUniqueOrderedLibraryIds() {
    ArrayList<Library> orderedLibraries = getOrderedLibraries();
    return orderedLibraries.stream()
        .map((Library::getId))
        .collect(Collectors.toList());
  }

  public List<Integer> parseOrderedBooks(Integer libraryId) {
    return result.getBookPackages().stream()
        .filter(bookPackage -> bookPackage.getLibrary().getId() == libraryId)
        .map(BookPackage::getBooks)
        .flatMap(Collection::stream)
        .map(Book::getIndex)
        .collect(Collectors.toList());
  }

  private ArrayList<Library> getOrderedLibraries() {
    ArrayList<Library> orderedLibraries = new ArrayList<>();
    result.getBookPackages().forEach((BookPackage bp) -> {
      if (!orderedLibraries.contains(bp.getLibrary())) {
        orderedLibraries.add(bp.getLibrary());
      }
    });
    return orderedLibraries;
  }
}
