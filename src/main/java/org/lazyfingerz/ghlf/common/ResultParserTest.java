package org.lazyfingerz.ghlf.common;

import org.junit.Test;
import org.lazyfingerz.ghlf.model.Book;
import org.lazyfingerz.ghlf.model.BookPackage;
import org.lazyfingerz.ghlf.model.LfResult;
import org.lazyfingerz.ghlf.model.Library;

import static java.util.Arrays.asList;

public class ResultParserTest {

  @Test
  public void test() {
    LfResult result = new LfResult();
    Book b1 = new Book(0, 0);
    Book b2 = new Book(1, 1);
    Book b3 = new Book(2, 2);
    Book b4 = new Book(3, 3);
    Library lib1 = new Library();
    lib1.setBooks(asList(b1, b2));
    Library lib2 = new Library();
    lib2.setBooks(asList(b3, b4));

    result.add(new BookPackage(lib1, asList(b1)));
  }
}