package com.book.book.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Announcements {

  private Integer id;
  private String title;
  private String status;
  private java.sql.Timestamp publishTime;
  private String publisher;
  private String preview;



}
