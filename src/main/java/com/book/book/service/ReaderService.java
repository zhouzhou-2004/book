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

    //新增功能
    int addReader(Users users);
    //判断用户是否存在
    int checkReaderName(String username);

    //根据id修改管理员功能
    int updateReader(UserVO userVO);
    //删除功能
    int deleteReader(int id);

    //批量删除
    int deleteReadersById(List<Long> id);
}
