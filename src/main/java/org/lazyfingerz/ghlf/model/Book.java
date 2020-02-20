package org.lazyfingerz.ghlf.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Book implements Comparable<Book> {

  private int index;

  private int value;


    @Override
    public int compareTo(Book other) {
        return Integer.compare(this.value, other.value);
    }
}
