package com.book.book.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
