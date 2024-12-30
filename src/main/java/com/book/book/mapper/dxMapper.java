package com.book.book.mapper;

import com.book.book.model.pojo.Users;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface dxMapper {

    //dx 检查用户名是否重复
    @Select("select * from users where username = #{username}")
    Users checkName(Users users);

    //dx   登录
    @Select("select * from users where username = #{username} and password = #{password}")
    Users login(Users users);

    //dx  注册
    @Insert("insert into users (nickname,username, password,tel) values ('游客',#{username},#{password},#{tel})")
    int register(Users users);

    //dx 手机验证码
    @Select("select * from users where tel = #{tel}")
    Users selectPhone(String tel);
}
