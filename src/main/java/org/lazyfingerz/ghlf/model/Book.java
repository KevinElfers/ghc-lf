package org.lazyfingerz.ghlf.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;

@Data
@AllArgsConstructor
public class Book implements Comparable<Book> {

    private int index;

    private int value;


    @Override
    public int compareTo(Book book) {
        return Comparator.comparingInt(Book::getValue).compare(this, book);
    }
}
