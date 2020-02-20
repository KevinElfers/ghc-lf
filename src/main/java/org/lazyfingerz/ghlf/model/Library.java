package org.lazyfingerz.ghlf.model;

import lombok.Data;

import java.util.List;

@Data
public class Library {

  Integer id;
  Integer signup;
  Integer booksCapacity;
  List<Book> books;

}
