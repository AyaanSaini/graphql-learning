package com.gaurav.graphql.learning.service;

import java.util.List;


import com.gaurav.graphql.learning.model.Book;

public interface BookService {

  Book saveBook(Book book);

  Book getBook(int id);

  List<Book> getBooks();

  List<Book> addMultiple(List<Book> books);
}
