package com.book.book.service.impl;


import com.book.book.mapper.UsersMapper;
import com.book.book.model.pojo.Users;
import com.book.book.model.vo.UserVO;
import com.book.book.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public List<UserVO> getAllUser() {
        List<UserVO> allUser = usersMapper.getAllUser();
        if (allUser != null){
            return allUser;
        }else {
            return null;
        }
    }

    @Override
    public List<UserVO> selectLike(String LikeName) {
        try {
            List<UserVO> userVOS = usersMapper.selectLike(LikeName);
            if (userVOS != null){
                //查询到数据，返回
                return userVOS;
            }else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateUser(UserVO userVO) {
        try {
            int result = usersMapper.updateUser(userVO);
            if (result > 0){
                //添加成功
                return 1;
            }else {
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteUser(int id) {
        try {
            int deleteUser = usersMapper.deleteUser(id);
            if (deleteUser > 0){
                //删除成功
                return 1;
            }else {
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Users getUserById(String username) {
        try {
            Users userById = usersMapper.getUserById(username);
            if (userById != null){
                //该用户存在
                return userById;
            }else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public int addUser(Users users) {
        try {
            int addUser = usersMapper.addUser(users);
            if (addUser > 0){
                //添加成功
                return 1;
            }else {
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int checkUsername(String username) {
        try {
            Users checkUsername = usersMapper.checkUsername(username);
            if (checkUsername != null){
                //该用户存在
                return 1;
            }else {
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

