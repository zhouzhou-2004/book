package com.book.book.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class BookLogin {
    private Integer id;
    private String name;
    private String author;
    private String isbn;
    private Integer pages;
    private double price;
    private String publish;
    private String publishTime;
    private Integer size;
    private String type;
    private Integer isDelete;

}
