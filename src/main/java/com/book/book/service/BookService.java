package com.book.book.service;

import com.book.book.model.pojo.Book;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookService {
    //查询所有图书
    List<Book> BookAll();
//    修改图书
    int updateBook(Book book);
//    删除图书
    int deleteBook(int id);
}
