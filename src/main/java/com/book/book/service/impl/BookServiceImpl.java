package com.book.book.service.impl;

import com.book.book.mapper.BookMapper;
import com.book.book.model.pojo.Book;
import com.book.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<Book> BookAll() {
        List<Book> books = bookMapper.BookAll();
        if (books != null) {
            return books;
        }else {
            return null;
        }
    }

    @Override
    public int updateBook(Book book) {
        try {
            int result = bookMapper.updateBook(book);
            if (result > 0){
                return 1;
            }else {
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteBook(int id) {
        try {
            int deleteUser = bookMapper.deleteBook(id);
            if (deleteUser > 0){
                //删除成功
                return 1;
            }else {
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
