package com.book.book.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Announcements {

  private int id;
  private String title;
  private String status;
  private String publishTime;
  private String publisher;
  private String preview;
  private long isDelete;


}
