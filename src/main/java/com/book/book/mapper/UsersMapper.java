package com.book.book.mapper;

import com.book.book.model.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UsersMapper {
    //获取所有用户
    @Select("select * from users where is_admin = 0")
    List<UserVO> getAllUser();
    //模糊查询(用户名或昵称)
    @Select("select * from users where username like concat('%',#{username},'%') or nickname  like concat('%',#{username},'%') and is_admin=0")
    List<UserVO> selectLike(String LikeName);
    //根据id修改管理员功能
    @Update("update users set nickname=#{nickname},username=#{username},birthday=#{birthday},tel=#{tel},email=#{email},address=#{address},size=#{size},identity=#{identity} where id=#{id}")
    int updateUser(UserVO userVO);
    //删除功能
    @Update("update users set is_admin = 1 where id=#{id}")
    int deleteUser(int id);
}