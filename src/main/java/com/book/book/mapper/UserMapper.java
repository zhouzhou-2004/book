package com.book.book.mapper;

import com.book.book.model.pojo.Users;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    //用户管理
    @Select("select * from user where is_admin = 0")
    List<Users> getAllUser();
}
