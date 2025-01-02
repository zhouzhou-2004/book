package com.book.book.service;

import com.book.book.model.dto.QueryRequest;
import com.book.book.model.pojo.Users;
import com.book.book.model.vo.UserVO;
import com.book.book.utils.PageResult;

import java.util.List;

public interface ReaderService {
    PageResult<UserVO> selectReaderList(QueryRequest queryRequest);
//    PageResult<Users> selectReaderList(QueryRequest queryRequest);
//    /**
//     * 模糊查询
//     */

    List<UserVO> selectByLike(String LikeName);
}
