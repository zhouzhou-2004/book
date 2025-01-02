package com.book.book.service.impl;

import com.book.book.mapper.BorrowMapper;
import com.book.book.model.dto.QueryRequest;
import com.book.book.model.pojo.Book;
import com.book.book.service.BorrowService;
import com.book.book.utils.PageResult;
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
}

