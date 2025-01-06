package com.book.book.model.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class Announcements {

  private int id;
  private String title;
  private String status;
  private String publishTime;
  private String publisher;
  private String preview;
  private long isDelete;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }
}
