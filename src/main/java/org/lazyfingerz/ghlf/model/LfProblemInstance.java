package org.lazyfingerz.ghlf.model;

import java.util.HashSet;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LfProblemInstance {

    int numberOfBooks;
    int numberOfLibraries;
    int days;
    List<Book> books;
    HashSet<Library> libraries;

    public void addLibrary(Library library) {
        libraries.add(library);
    }
}

