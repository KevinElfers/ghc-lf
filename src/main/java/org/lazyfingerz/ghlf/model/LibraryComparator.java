package org.lazyfingerz.ghlf.model;

import lombok.AllArgsConstructor;

import java.util.Comparator;

@AllArgsConstructor
public class LibraryComparator implements Comparator<Library> {

    Integer leftDays;

    @Override
    public int compare(Library library, Library other) {
        return library.compareTo(other, leftDays);
    }
}
