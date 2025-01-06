package com.book.book.service.impl;

import com.book.book.mapper.BorrowMapper;
import com.book.book.model.dto.QueryRequest;
import com.book.book.model.pojo.Book;
import com.book.book.model.pojo.Borrow;
import com.book.book.service.BorrowService;
import com.book.book.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
        } else {
            return null;
        }
    }

    @Override
    public List<Book> searchBook(String name) {
        try {
            List<Book> books = borrowMapper.searchBook(name);
            if (books != null){
                //查询到数据，返回
                return books;
            }else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PageResult<Book> selectBookPage(QueryRequest queryRequest) {
        // 计算偏移量(起始索引) （查询页码-1）*每页显示记录数。
        int offset = (queryRequest.getPageNum() - 1) * queryRequest.getPageSize();
        //查询总记录数
        Long total = borrowMapper.selectTotal(queryRequest.getClassNo(), queryRequest.getName());
        //todo : 如果没有记录，直接返回空结果
        // if (total == 0) {
        //     return new PageResult<>(new ArrayList<>(), queryRequest.getPageNum(),
        //             queryRequest.getPageSize(), 0L);
        // }
        List<Book> books = borrowMapper.selectBookPage(queryRequest.getClassNo(), queryRequest.getName(), offset, queryRequest.getPageSize());

        return new PageResult<>(books,queryRequest.getPageNum(),queryRequest.getPageSize(),total);
    }

    @Override
    public boolean checkUserExists(Integer userId) {
        return borrowMapper.checkUserExists(userId) > 0;
    }

    @Override
    public int getUserBorrowCount(Integer userId) {
        return borrowMapper.getUserBorrowCount(userId);
    }

    @Override
    public Map<String, Object> borrowBook(Integer userId, String bookName, String author,
                                          String borrowTime, String returnTime) {
        Map<String, Object> result = new HashMap<>();

        try {
            // 检查用户是否存在
            if (!checkUserExists(userId)) {
                result.put("success", false);
                result.put("message", "用户不存在");
                return result;
            }

            // 检查用户借阅数量是否达到上限
            int currentBorrowCount = getUserBorrowCount(userId);
            if (currentBorrowCount >= 3) {
                result.put("success", false);
                result.put("message", "已达到最大借阅数量限制");
                return result;
            }

            // 检查图书是否存在且有库存
            Book book = borrowMapper.getBookByNameAndAuthor(bookName, author);
            if (book == null) {
                result.put("success", false);
                result.put("message", "图书不存在");
                return result;
            }

            if (book.getSize() <= 0) {
                result.put("success", false);
                result.put("message", "该图书库存不足");
                return result;
            }

            // 创建借阅记录
            Borrow borrow = new Borrow();
            borrow.setBookId(book.getId());
            borrow.setUserId(userId);
            borrow.setCreateTime(borrowTime);
            borrow.setEndTime(returnTime);
            borrow.setRet(0);  // 0表示未归还

            // 开始事务操作：更新库存和插入借阅记录
            int updateResult = borrowMapper.updateBookStock(book.getId());
            if (updateResult <= 0) {
                result.put("success", false);
                result.put("message", "库存更新失败");
                return result;
            }

            int insertResult = borrowMapper.insertBorrow(borrow);
            if (insertResult <= 0) {
                result.put("success", false);
                result.put("message", "借阅记录创建失败");
                return result;
            }

            result.put("success", true);
            result.put("message", "借阅成功");
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("message", "借阅失败借阅失败，图书名或作者信息错误：" + e.getMessage());
            return result;
        }
    }
}

