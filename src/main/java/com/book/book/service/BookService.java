package com.book.book.service;

import com.book.book.model.pojo.Book;


import java.util.List;

public interface BookService {
    //查询所有图书
    List<Book> BookAll();
//    修改图书
    int updateBook(Book book);
//    删除图书
    int deleteBook(int id);
    // 添加图书
    int addBook(Book book);
    // 搜索图书
    List<Book> searchBooks(String keyword, String type);
}
