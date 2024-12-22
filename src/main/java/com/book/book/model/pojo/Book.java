package com.book.book.model.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

  private long id;
  private String author;
  private String isbn;
  private String name;
  private long pages;
  private double price;
  private String publish;
  private String publishTime;
  private long size;
  private String translate;
  private String type;

}
