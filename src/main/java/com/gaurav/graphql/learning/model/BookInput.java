package com.gaurav.graphql.learning.model;

import lombok.Data;

@Data
public class BookInput {

  private String name;
  private String description;
  private String author;
  private int pages;
  private float price;
}
