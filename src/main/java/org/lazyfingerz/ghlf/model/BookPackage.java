package org.lazyfingerz.ghlf.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class BookPackage {

  Library library;
  ArrayList<Book> books;

}
