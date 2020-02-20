package org.lazyfingerz.ghlf.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class LfResult {

  List<BookPackage> bookPackages = new ArrayList<>();

  public void add(BookPackage bp) {
    bookPackages.add(bp);
  }
}
