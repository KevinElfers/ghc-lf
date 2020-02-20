package org.lazyfingerz.ghlf.common;

import org.junit.Test;
import org.lazyfingerz.ghlf.model.Book;
import org.lazyfingerz.ghlf.model.BookPackage;
import org.lazyfingerz.ghlf.model.LfResult;
import org.lazyfingerz.ghlf.model.Library;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class ResultParserTest {

  @Test
  public void test_getOrderedBooks() {
    //given
    LfResult result = new LfResult();
    Book b1 = new Book(0, 0);
    Book b2 = new Book(1, 1);
    Book b3 = new Book(2, 2);
    Book b4 = new Book(3, 3);
    Library lib2 = new Library(1, null, null, null, asList(b3, b4));
    Library lib1 = new Library(0, null, null, null, asList(b1, b2));

    result.add(new BookPackage(lib1, asList(b3, b4)));
    result.add(new BookPackage(lib2, asList(b3, b4)));
    result.add(new BookPackage(lib1, asList(b1, b2)));
    result.add(new BookPackage(lib2, asList(b3, b4)));

    //when
    ResultParser parser = new ResultParser(result);
    List<Integer> bookIds = parser.parseOrderedBooks(0);

    //then
    assertEquals(bookIds.size(), 4);
    assertEquals(bookIds.get(0), Integer.valueOf(2));
    assertEquals(bookIds.get(1), Integer.valueOf(3));
    assertEquals(bookIds.get(2), Integer.valueOf(0));
    assertEquals(bookIds.get(3), Integer.valueOf(1));
  }

  @Test
  public void test_parseUniqueOrderedLibraryIds() {
    //given
    LfResult result = new LfResult();
    Book b1 = new Book(0, 0);
    Book b2 = new Book(1, 1);
    Book b3 = new Book(2, 2);
    Book b4 = new Book(3, 3);
    Library lib2 = new Library(1, null, null, null, asList(b3, b4));
    Library lib1 = new Library(0, null, null, null, asList(b1, b2));

    result.add(new BookPackage(lib1, asList(b1, b2)));
    result.add(new BookPackage(lib2, asList(b3, b4)));
    result.add(new BookPackage(lib1, asList(b3, b4)));
    result.add(new BookPackage(lib2, asList(b3, b4)));

    //when
    ResultParser parser = new ResultParser(result);
    List<Integer> libraryIds = parser.parseUniqueOrderedLibraryIds();

    //then
    assertEquals(libraryIds.size(), 2);
    assertEquals(libraryIds.get(0), Integer.valueOf(0));
    assertEquals(libraryIds.get(1), Integer.valueOf(1));
  }
}