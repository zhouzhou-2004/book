package com.book.book.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Borrow {

  private long id;
  private long bookId;
  private String createTime;
  private String updateTime;
  private long userId;
  private String endTime;
  private long ret;

}
