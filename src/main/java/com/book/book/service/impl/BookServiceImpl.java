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
    @Override
    public int addBook(Book book) {
        try {
            // 验证必填字段
            if (book.getName() == null || book.getName().trim().isEmpty() ||
                    book.getAuthor() == null || book.getAuthor().trim().isEmpty() ||
                    book.getIsbn() == null || book.getIsbn().trim().isEmpty()) {
                return 0;
            }
            // 去除用户可能输入的书名号
            book.setName(book.getName().replace("《", "").replace("》", "").trim());
            return bookMapper.addBook(book);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
//    搜索功能的实现
    @Override
    public List<Book> searchBooks(String keyword, String type) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return null;
        }
        switch (type) {
            case "name":
                return bookMapper.searchByName(keyword);
            case "author":
                return bookMapper.searchByAuthor(keyword);
            case "isbn":
                return bookMapper.searchByIsbn(keyword);
            default:
                return null;
        }
    }
}
