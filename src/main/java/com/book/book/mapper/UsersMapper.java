package com.book.book.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


/**
 * @Description
 * @Date 2024/12/18 19:57
 * @Author by me
 */
@Mapper
@Component
public interface UsersMapper {

    /**
     * 模糊分页查询用户
     * @param keyword 关键字
     * @return
     */
    //List<Users> findListByLike(String keyword);

    /**
     * 编辑用户
     * @param map
     * @return
     */
    //int updateUsers(Map<String,Object> map);
}
