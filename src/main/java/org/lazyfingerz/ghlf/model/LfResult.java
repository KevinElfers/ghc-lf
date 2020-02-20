package org.lazyfingerz.ghlf.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LfResult {

  List<BookPackage> bookPackages = new ArrayList<>();

  public void add(BookPackage bp) {
    bookPackages.add(bp);
  }

  public int getScore() {
    int score = 0;
    for (BookPackage bookPackage : bookPackages) {
      for (Book book : bookPackage.books) {
        score += book.getValue();
      }
    }
    return score;
  }
}
