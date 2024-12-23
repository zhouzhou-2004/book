package com.book.book.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryInfo {
  private long id;
  private String libraryName;
  private String address;
  private String openTime;
  private String contactPhone;

}
