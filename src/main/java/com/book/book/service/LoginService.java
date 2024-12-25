package com.book.book.service;

import com.book.book.model.pojo.Users;


public interface LoginService {

    //检查用户名是否重复
    Users checkName(Users users);

    //登录
    Users login(Users users);

    //注册
    int register(Users users);
}
