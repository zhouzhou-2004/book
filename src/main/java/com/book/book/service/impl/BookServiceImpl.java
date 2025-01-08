package com.book.book.service.impl;

import com.book.book.mapper.BookMapper;
import com.book.book.model.pojo.Book;
import com.book.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//分页查询
@Override
public Map<String, Object> getBooksByPage(int pageNum, int pageSize) {
    Map<String, Object> result = new HashMap<>();
    // 计算起始位置
    int start = (pageNum - 1) * pageSize;
    // 获取分页数据
    List<Book> books = bookMapper.selectByPage(start, pageSize);
    // 获取总记录数
    int total = bookMapper.selectTotalCount();
    // 计算总页数
    int totalPages = (total + pageSize - 1) / pageSize;
    // 封装结果
    result.put("books", books);
    result.put("total", total);
    result.put("pageNum", pageNum);
    result.put("pageSize", pageSize);
    result.put("totalPages", totalPages);
    return result;
    }
}
