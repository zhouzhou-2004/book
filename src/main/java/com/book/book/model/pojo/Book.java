package com.book.book.model.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

  private int id;
  private String name;
  private String author;
  private String isbn;
  private int pages;
  private double price;
  private String publish;
  private String publishTime;
  private int size;
  private String type;
  private Integer isDelete;


}
