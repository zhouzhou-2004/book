package com.book.book.service;

import com.book.book.model.pojo.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BorrowService {
    //功能1：获取所有图书信息
    List<Book> selectBooKAll();
}
