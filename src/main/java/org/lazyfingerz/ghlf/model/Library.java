package org.lazyfingerz.ghlf.model;

import lombok.*;

import java.util.*;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Library implements Comparable<Library> {

  Integer id;
  Integer signup;
  Integer booksCapacity;
  List<Book> books;

  public List<Book> getBestBooks() {
    TreeSet<Book> sortedBooks = new TreeSet<>(books);
    ArrayList<Book> result = new ArrayList<>();
    for (int i = 0; i < booksCapacity && !sortedBooks.isEmpty(); i++) {
      result.add(sortedBooks.pollLast());
    }
    return result;
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
