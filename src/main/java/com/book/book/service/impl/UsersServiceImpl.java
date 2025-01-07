package com.book.book.service.impl;


import com.book.book.mapper.UsersMapper;
import com.book.book.model.dto.QueryRequest;
import com.book.book.model.pojo.Users;
import com.book.book.model.vo.UserVO;
import com.book.book.service.UsersService;
import com.book.book.utils.PageResult;
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

    public PageResult<UserVO> selectLikeWithPage(QueryRequest queryRequest) {
        // 计算偏移量
        int offset = (queryRequest.getPageNum() - 1) * queryRequest.getPageSize();

        // 获取模糊查询结果
        List<UserVO> userVOList = usersMapper.selectLike(queryRequest.getUserText(), offset, queryRequest.getPageSize());

        // 获取总记录数
        Long total = usersMapper.selectLikeTotal(queryRequest.getUserText());

        return new PageResult<>(userVOList, queryRequest.getPageNum(), queryRequest.getPageSize(), total);
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
    public PageResult<UserVO> userSelectList(QueryRequest queryRequest) {
        // 计算偏移量(起始索引) （查询页码-1）*每页显示记录数。
        int offset = (queryRequest.getPageNum() - 1) * queryRequest.getPageSize();
        //查询总记录数
        Long total = usersMapper.userSelectTotal(queryRequest.getClassNo(), queryRequest.getName());
        //todo : 如果没有记录，直接返回空结果
        // if (total == 0) {
        //     return new PageResult<>(new ArrayList<>(), queryRequest.getPageNum(),
        //             queryRequest.getPageSize(), 0L);
        // }
        List<UserVO> userVOList = usersMapper.userSelectList(queryRequest.getClassNo(), queryRequest.getName(), offset, queryRequest.getPageSize());

        return new PageResult<>(userVOList,queryRequest.getPageNum(),queryRequest.getPageSize(),total);
    }

    @Override
    public Users getUserByUsername(String username) {
        try {
            Users userById = usersMapper.getUserByUsername(username);
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

