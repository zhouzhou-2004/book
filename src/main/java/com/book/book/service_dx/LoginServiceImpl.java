package com.book.book.service_dx;

import com.book.book.mapper.userMapper;
import com.book.book.model.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private userMapper usermapper;
    @Override
    public Users login(Users users) {
        try {
            Users result = usermapper.login(users);
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
}
