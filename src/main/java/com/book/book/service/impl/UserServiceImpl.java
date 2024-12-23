package com.book.book.service.impl;

import com.book.book.mapper.UserMapper;
import com.book.book.mapper.UsersMapper;
import com.book.book.model.pojo.Users;
import com.book.book.model.vo.UserVO;
import com.book.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    //依赖注入
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<UserVO> getAllUser() {
        List<UserVO> allUser = userMapper.getAllUser();
        if (allUser != null) {
            return allUser;
        } else {
            return null;
        }
    }
}
