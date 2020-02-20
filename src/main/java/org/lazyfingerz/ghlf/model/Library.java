package org.lazyfingerz.ghlf.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
public class Library implements Comparable<Library> {

  Integer id;
  Integer signup;
  Integer booksCapacity;
  List<Book> books;

  public static ArrayList<Book> getBestBooks() {
    //TODO
    return null;
  }

  public int getValue() {
    int value = 0;
    for (Book book : books) {
      value += book.getValue();
    }
    return value;
  }

  public int getValue(Collection<Book> exclude) {
    int value = 0;
    List<Book> remainingBooks = new LinkedList<>(books);
    remainingBooks.removeAll(exclude);
    for (Book book : remainingBooks) {
      value += book.getValue();
    }
    return value;
  }

  @Override
  public int compareTo(Library other) {
    return Integer.compare(this.getValue(), other.getValue());
  }

  public int compareTo(Library other, Collection<Book> exclude) {
    return Integer.compare(this.getValue(exclude), other.getValue(exclude));
  }

}
