package com.book.book.service;

import com.book.book.model.dto.queryRequest.QueryRequest;
import com.book.book.model.pojo.Users;
import com.book.book.utils.PageResult;

import java.util.List;

public interface ReaderService {
    PageResult<Users> selectReaderList(QueryRequest queryRequest);
//    PageResult<Users> selectReaderList(QueryRequest queryRequest);
//    /**
//     * 模糊查询
//     */
//    List<Users> selectByLike(String likeName);
}
