package org.lazyfingerz.ghlf.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Library implements Comparable<Library> {

  Integer id;
  Integer signup;
  Double globalAvgSignup;
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

  public Double getScore(int leftDays) {
    if(leftDays <= signup){
      // zu wenig Zeit noch etwas zu machen
      return -1.0;
    }
    int maximumAmountOfBooks = (leftDays - signup) * booksCapacity;
    if (maximumAmountOfBooks > books.size()) {
      maximumAmountOfBooks = books.size();
    }
    int score = 0;
    for (int i = 0; i < maximumAmountOfBooks; i++) {
      score += books.get(books.size()-1-i).getValue();
    }
    return ((double)score) / signup;
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
    return Double.compare(this.getScore(leftDays), other.getScore(leftDays));
  }

}
