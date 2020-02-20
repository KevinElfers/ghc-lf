package org.lazyfingerz.ghlf.processor;

import org.lazyfingerz.ghlf.model.*;

import java.util.*;

public class LfProcessor {

    public LfResult process(LfProblemInstance problemInstance) {

        List<Book> alreadyUsedBooks = new ArrayList<>();
        List<BookPackage> allBookPackages = new ArrayList<>();
        List<Library> SubscribedLibraries;

        int day = 0;

        while (day < problemInstance.getDays()) {
            day--;
            TreeSet<Library> libraries = new TreeSet<>(new LibraryComparator(alreadyUsedBooks));

            //create bookpackages for current day from all subscribed libraries;
            HashSet<BookPackage> newBookPackages = new HashSet<>();
            BookPackage newBookPackage;

            // remove new packages from all libraries
            for (Library library : libraries) {
                for (BookPackage bookPackage : newBookPackages) {
                    library.getBooks().removeAll(bookPackage.getBooks());
                }
            }

            // add new packages to result
            allBookPackages.addAll(newBookPackages);
        }


        return new LfResult(allBookPackages);
    }



}

