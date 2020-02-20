package org.lazyfingerz.ghlf.processor;

import org.lazyfingerz.ghlf.model.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class LfProcessor {

    public LfResult process(LfProblemInstance problemInstance) {

        HashSet<Library> subscribedLibraries = new HashSet<>();
        List<Library> unsubscribedLibraries = new ArrayList<>(problemInstance.getLibraries());
        LfResult result = new LfResult();
        Library currentlySigningUpLibrary = null;


        int day = 0;
        int daysToSignUp = 0;

        while (day < problemInstance.getDays() ) {
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
                List<Book> scannedBooks = subscribed.getBestBooks();
                BookPackage bookPackage = new BookPackage(subscribed, scannedBooks);


                //add to result
                result.add(bookPackage);

                // remove new package from all libraries
                for (Library library : unsubscribedLibraries) {
                    library.getBooks().removeAll(bookPackage.getBooks());
                }
                for (Library library : subscribedLibraries) {
                    library.getBooks().removeAll(bookPackage.getBooks());
                }
                if (currentlySigningUpLibrary != null) {
                    currentlySigningUpLibrary.getBooks().removeAll(bookPackage.getBooks());
                }
            }

            // unsubscribe empty libraries
            subscribedLibraries.removeIf(subscribed -> subscribed.getBooks().isEmpty());

            // select next library to subscribe
            if (daysToSignUp <= 0 && ! unsubscribedLibraries.isEmpty()) {
                TreeSet<Library> rankedLibraries = new TreeSet<>(new LibraryComparator(problemInstance.getDays() - day));
                rankedLibraries.addAll(unsubscribedLibraries);
                currentlySigningUpLibrary = rankedLibraries.last();
                daysToSignUp = currentlySigningUpLibrary.getSignup();
                unsubscribedLibraries.remove(currentlySigningUpLibrary);
            }

        }

        return result;
    }



}

