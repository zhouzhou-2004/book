package com.book.book.service;

import com.book.book.model.dto.QueryRequest;
import com.book.book.model.pojo.Book;
import com.book.book.utils.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BorrowService {
    //功能1：获取所有图书信息
    List<Book> selectBooKAll();
//    功能2；搜索图书
    List<Book> searchBook(String name);
//    分页查询
    PageResult<Book> selectBookPage(QueryRequest queryRequest);
}
