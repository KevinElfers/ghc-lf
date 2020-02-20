package org.lazyfingerz.ghlf.model;

import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.Comparator;

@AllArgsConstructor
public class LibraryComparator implements Comparator<Library> {

    Collection<Book> exclude;

    @Override
    public int compare(Library library, Library other) {
        return library.compareTo(other, exclude);
    }
}
