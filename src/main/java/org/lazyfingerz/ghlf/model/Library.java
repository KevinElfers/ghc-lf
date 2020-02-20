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

  public void sortBooks() {
    Collections.sort(books);
  }

  public List<Book> getBestBooks() {
    ArrayList<Book> result = new ArrayList<>();
    for (int i = 0; i < booksCapacity && !books.isEmpty(); i++) {
      result.add(books.get(books.size()-1));
      books.remove(books.get(books.size()-1));
    }
    return result;
  }

  public int getScore(int leftDays) {
    int maximumAmountOfBooks = (leftDays - signup) * booksCapacity;
    if (maximumAmountOfBooks > books.size()) {
      maximumAmountOfBooks = books.size();
    }
    int score = 0;
    for (int i = 0; i < maximumAmountOfBooks; i++) {
      score += books.get(books.size()-1-i).getValue();
    }
    return score;
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

  public int compareTo(Library other, Integer leftDays) {
    return Integer.compare(this.getScore(leftDays), other.getScore(leftDays));
  }

}
