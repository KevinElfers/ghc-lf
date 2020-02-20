package org.lazyfingerz.ghlf.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;
import org.lazyfingerz.ghlf.model.Book;
import org.lazyfingerz.ghlf.model.LfProblemInstance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.lazyfingerz.ghlf.model.Library;

public class LfReader {

    public LfProblemInstance read(String filename) throws IOException {
        LinkedList<Integer> input = new LinkedList<>();
        LfProblemInstance problemInstance = new LfProblemInstance();
        problemInstance.setBooks(new ArrayList<>());
        problemInstance.setLibraries(new HashSet<>());

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            int lineCounter = 0;
            int libraryId = 0;

            Library lib = new Library();
            for (String line; (line = br.readLine()) != null; ) {
                if (lineCounter == 0) {
                    String [] inp = line.split(" ");
                    problemInstance.setNumberOfBooks(Integer.parseInt(inp[0]));
                    problemInstance.setNumberOfLibraries(Integer.parseInt(inp[1]));
                    problemInstance.setDays(Integer.parseInt(inp[2]));
                }
                if (lineCounter == 1) {
                    int index = 0;
                    List<Book> books = new ArrayList<>();
                    for (String i : line.split(" ")) {
                        books.add(new Book(index, Integer.parseInt(i)));
                        index++;
                    }
                    problemInstance.setBooks(books);
                }
                if (lineCounter > 1) {
                    // 1. library erstellen mit index, # books, books per day
                    if (lineCounter % 2 == 0)
                    {
                        String[] inp = line.split(" ");
                        lib = new Library(
                            libraryId,
                            Integer.parseInt(inp[1]),
                            Integer.parseInt(inp[2]), null);
                        libraryId++;
                    } else {
                        String[] inp = line.split(" ");
                        lib.setBooks(
                            Arrays.stream(inp).map(
                                i -> problemInstance.getBooks().get(Integer.parseInt(i))
                            ).collect(Collectors.toList())
                        );
                        problemInstance.addLibrary(lib);
                    }

                }
                lineCounter++;
            }
        }
        return problemInstance;
    }

    private Integer parseLine(String line, int lineIndex) {
        List<String> elements = new LinkedList(Arrays.asList((line.split(" "))));

        //add logic below
        return Integer.valueOf(elements.get(0));
    }

}
