package org.lazyfingerz.ghlf.common;

import org.lazyfingerz.ghlf.model.BookPackage;
import org.lazyfingerz.ghlf.model.LfResult;
import org.lazyfingerz.ghlf.model.Library;

import java.util.ArrayList;

public class ResultParser {

  LfResult result;


  public ResultParser(LfResult result) {
    this.result = result;
  }

  public String parseUniqueLibraryIds(){
    return "";
  }

  private ArrayList<Library> getOrderedLibraries() {
    ArrayList<Library> orderedLibraries = new ArrayList<>();
    result.getBookPackages().forEach((BookPackage bp) -> {
      if (orderedLibraries.contains(bp.getLibrary())) {
        orderedLibraries.add(bp.getLibrary());
      }
    });
    return orderedLibraries;
  }

}
