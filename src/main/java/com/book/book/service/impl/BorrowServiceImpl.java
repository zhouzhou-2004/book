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

    @Override
    public int deleteBook(int id) {
        try {
            int result = borrowMapper. deleteBook(id);
            if (result > 0){
                //添加成功
                return 1;
            }else {
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
