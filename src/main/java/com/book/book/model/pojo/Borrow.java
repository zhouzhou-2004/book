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

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getBookId() {
    return bookId;
  }

  public void setBookId(long bookId) {
    this.bookId = bookId;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public long getRet() {
    return ret;
  }

  public void setRet(long ret) {
    this.ret = ret;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }
}
