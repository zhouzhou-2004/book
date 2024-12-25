package com.book.book.service.impl;

import com.book.book.mapper.dxMapper;
import com.book.book.model.pojo.Users;
import com.book.book.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private dxMapper dxmapper;

    //检查用户名是否重复
    @Override
    public Users checkName(Users users) {
        try {
            Users result = dxmapper.checkName(users);
            if (result != null){
                //登录成功
                return result;
            }else {
                //登录失败
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //登录
    @Override
    public Users login(Users users) {
        try {
            Users result = dxmapper.login(users);
            if (result != null){
                //登录成功
                return result;
            }else {
                //登录失败
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //注册
    @Override
    public int register(Users users) {
        try {
            int result = dxmapper.register(users);
            if (result > 0){
                //注册成功
                return 1;
            }else {
                //注册失败
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
