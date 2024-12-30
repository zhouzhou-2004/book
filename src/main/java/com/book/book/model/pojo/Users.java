package com.book.book.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

  private long id;
  private String address;
  private String birthday;
  private String email;
  private long identity;
  private long isAdmin;
  private String nickname;
  private String password;
  private long size;
  private String tel;
  private String username;
  private String code;
  private boolean remember;


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public String toString() {
    return "Users{" +
            "password='" + password + '\'' +
            ", username='" + username + '\'' +
            ", code='" + code + '\'' +
            '}';
  }

  public boolean isRemember() {
    return remember;
  }

  public void setRemember(boolean remember) {
    this.remember = remember;
  }
}
