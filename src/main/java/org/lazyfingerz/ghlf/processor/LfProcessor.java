package org.lazyfingerz.ghlf.processor;

import org.lazyfingerz.ghlf.model.*;

import java.util.*;

public class LfProcessor {

    public LfResult process(LfProblemInstance problemInstance) {

        HashSet<Library> subscribedLibraries = new HashSet<>();
        List<Library> libraries = new ArrayList<>(problemInstance.getLibraries());
        LfResult result = new LfResult();
        Library currentlySigningUpLibrary = null;


        int day = 0;
        int daysToSignUp = 0;

        while (day < problemInstance.getDays()) {
            day++;
            daysToSignUp--;

            // add signing up library if signup time is over
            if (daysToSignUp == 0) {
                subscribedLibraries.add(currentlySigningUpLibrary);
                currentlySigningUpLibrary = null;
            }

            //create bookpackages for current day from all subscribed libraries;
            for (Library subscribed : subscribedLibraries) {

                //get scanned books
                ArrayList<Book> scannedBooks = Library.getBestBooks();
                BookPackage bookPackage = new BookPackage(subscribed, scannedBooks);

                //add to result
                result.add(bookPackage);

                // remove new package from all libraries
                for (Library library : libraries) {
                    library.getBooks().removeAll(bookPackage.getBooks());
                }
            }

            // unsubscribe empty libraries
            subscribedLibraries.removeIf(subscribed -> subscribed.getBooks().size() == 0);

            // select next library to subscribe
            if (daysToSignUp > 0) {
                TreeSet<Library> rankedLibraries = new TreeSet<>(Comparator.naturalOrder());

                currentlySigningUpLibrary = rankedLibraries.first();
                daysToSignUp = currentlySigningUpLibrary.getSignup();
            }

        }

        return result;
    }



}

