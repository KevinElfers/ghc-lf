package org.lazyfingerz.ghlf.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class LfResult {

  List<BookPackage> bookPackages = new ArrayList<>();

  public void add(BookPackage bp) {
    bookPackages.add(bp);
  }
}
