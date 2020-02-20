package org.lazyfingerz.ghlf.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class BookPackage {

  Library library;
  ArrayList<Book> books;

}
