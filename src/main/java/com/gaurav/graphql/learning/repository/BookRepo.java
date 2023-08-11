package com.gaurav.graphql.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gaurav.graphql.learning.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
}
