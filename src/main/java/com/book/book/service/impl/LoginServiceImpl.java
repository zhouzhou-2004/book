package com.book.book.service.impl;

import cn.hutool.core.lang.UUID;
import com.book.book.mapper.dxMapper;
import com.book.book.model.pojo.Users;
import com.book.book.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private dxMapper dxmapper;
    private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

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

    //手机号验证码
    @Override
    public Users selectPhone(String tel,HttpServletRequest request) {
        //查询手机号是否存在
        Users result = dxmapper.selectPhone(tel);
        if (result == null){
            //手机号不存在
            //生成验证码
            int uuid = UUID.randomUUID().hashCode();
            uuid = Math.abs(uuid);
            String strUUID = String.format("%06d",uuid % 1000000);
            log.info("手机验证码"+strUUID);
            //将生成好的验证码储存到Session 中
            HttpSession session = request.getSession();
            //设置session最大非活动间隔时间为60秒
            session.setMaxInactiveInterval(60);
            session.setAttribute("UUIDcode",strUUID);
        }else {
            //手机号存在
            return result;
        }
        return result;
    }
}

