package com.book.book.service;

import com.book.book.mapper.UserMapper;
import com.book.book.model.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    //用户管理
    List<Users> getAllUser();
}
