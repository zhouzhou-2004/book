package com.book.book.service;


import com.book.book.model.pojo.Users;
import com.book.book.model.vo.UserVO;

import java.util.List;

public interface UsersService {
    //用户管理
    List<UserVO> getAllUser();
    //模糊查询(用户名或昵称)
    List<UserVO> selectLike(String LikeName);
    //根据id修改管理员功能
    int updateUser(UserVO userVO);
    //删除功能
    int deleteUser(int id);
    //新增功能
    int addUser(Users users);
    //判断用户是否存在
    int checkUsername(String username);
}
