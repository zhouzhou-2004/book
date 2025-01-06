package com.book.book.service;

import com.book.book.model.dto.QueryRequest;
import com.book.book.model.pojo.Book;
import com.book.book.model.pojo.Borrow;
import com.book.book.utils.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface BorrowService {
    //功能1：获取所有图书信息
    List<Book> selectBooKAll();
//    功能2；搜索图书
    List<Book> searchBook(String name);
    //    删除图书
    int deleteBook(int id);
    // 添加图书
    int addBook(Book book);
    //    修改图书
    Book getBookById(Integer id);
//    分页查询
    PageResult<Book> selectBookPage(QueryRequest queryRequest);
    // 检查用户是否存在
    boolean checkUserExists(Integer userId);

    // 获取用户当前借阅数量
    int getUserBorrowCount(Integer userId);
    // 借阅图书
    Map<String, Object> borrowBook(Integer userId, String bookName, String author, String borrowTime, String returnTime);

}
