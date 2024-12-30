package com.book.book.service.impl;

import com.book.book.mapper.BorrowMapper;
import com.book.book.model.pojo.Book;
import com.book.book.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
//    注入依赖
    @Autowired
    private BorrowMapper borrowMapper;

    @Override
    public List<Book> selectBooKAll() {
        List<Book> books = borrowMapper.selectBooKAll();
        if (books != null) {
            return books;
        }else {
            return null;
        }
    }
}
