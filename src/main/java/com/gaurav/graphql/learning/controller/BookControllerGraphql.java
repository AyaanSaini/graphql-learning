package com.gaurav.graphql.learning.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.gaurav.graphql.learning.model.Book;
import com.gaurav.graphql.learning.model.BookInput;
import com.gaurav.graphql.learning.service.BookService;

@Controller
public class BookControllerGraphql {

  @Autowired
  private BookService bookService;

  @MutationMapping("addBook")
  public Book createBook(@Argument BookInput bookInput){
    Book book = new Book();
    BeanUtils.copyProperties(bookInput,book);
    return bookService.saveBook(book);
  }

  @QueryMapping("getBook")
  public Book getBook(@Argument int bookId){
    return bookService.getBook(bookId);
  }

  @QueryMapping("getAllBooks")
  public List<Book> getBooks(){
    return bookService.getBooks();
  }

  @MutationMapping("addMultipleBooks")
  public List<Book> createMultipleBooks(@Argument List<BookInput> bookInputs){
    List<Book> books = new ArrayList<>();
    for (BookInput bookInput: bookInputs){
      Book book = new Book();
      BeanUtils.copyProperties(bookInput,book);
      books.add(book);
    }
    return bookService.addMultiple(books);
  }
}
