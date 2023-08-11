package com.gaurav.graphql.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.graphql.learning.model.Book;
import com.gaurav.graphql.learning.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

  @Autowired
  private BookService bookService;
  @PostMapping
  public Book createBook(@RequestBody Book book){
    return bookService.saveBook(book);
  }

  @GetMapping("/{id}")
  public Book getBook(@PathVariable int id){
    return bookService.getBook(id);
  }

  @GetMapping
  public List<Book> getBooks(){
    return bookService.getBooks();
  }

  @PostMapping("/addmultiple")
  public List<Book> createMultipleBooks(@RequestBody List<Book> books){
    return bookService.addMultiple(books);
  }
}
