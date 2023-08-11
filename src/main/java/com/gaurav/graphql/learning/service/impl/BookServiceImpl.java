package com.gaurav.graphql.learning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurav.graphql.learning.model.Book;
import com.gaurav.graphql.learning.repository.BookRepo;
import com.gaurav.graphql.learning.service.BookService;

@Service
public class BookServiceImpl implements BookService {

  @Autowired
  private BookRepo bookRepo;

  @Override
  public Book saveBook(Book book) {
    return bookRepo.save(book);
  }

  @Override
  public Book getBook(int id) {
    return bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Book not found by id " +id));
  }

  @Override
  public List<Book> getBooks() {
    return bookRepo.findAll();
  }

  @Override
  public List<Book> addMultiple(List<Book> books) {
      return bookRepo.saveAll(books);

  }
}
