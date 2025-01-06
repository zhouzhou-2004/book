package com.book.book.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Borrow {

  private long id;
//  图书id
  private long bookId;
//  借阅时间
  private String createTime;
//  实际归还时间
  private String updateTime;
//  用户id
  private long userId;
//  归还时间
  private String endTime;
//  是否归还
  private long ret;

}
