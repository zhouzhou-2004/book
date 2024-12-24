package com.book.book.mapper;

import com.book.book.model.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface userMapper {

    //dx   登录
    @Select("select * from users where username = #{username} and password = #{password}")
    Users login(Users users);


//    //用户管理
//    @Select("select * from user where is_admin = 0")
//    List<User> getAllUser();
}
