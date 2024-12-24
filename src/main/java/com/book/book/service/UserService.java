package com.book.book.service;

import com.book.book.model.vo.UserVO;

import java.util.List;

public interface UserService {
    //用户管理
    List<UserVO> getAllUser();
}
