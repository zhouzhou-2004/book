package com.book.book.mapper;

import com.book.book.model.pojo.Users;
import com.book.book.model.vo.UserVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UsersMapper {
    //获取所有用户
    @Select("select * from users where is_admin=0")
    List<UserVO> getAllUser();

    // 修改模糊查询方法
    List<UserVO> selectLike(@Param("username") String username,
                            @Param("offset") Integer offset,
                            @Param("pageSize") Integer pageSize);

    // 添加模糊查询总数方法
    Long selectLikeTotal(@Param("username") String username);

    //根据id修改管理员功能
    @Update("update users set nickname=#{nickname},username=#{username},birthday=#{birthday},tel=#{tel},email=#{email},address=#{address},size=#{size},identity=#{identity} where id=#{id}")
    int updateUser(UserVO userVO);

    //删除功能
    @Update("update users set is_admin = 1 where id=#{id}")
    int deleteUser(int id);

    //统计总记录数
    Long userSelectTotal(@Param("classNo") String classNo,
                     @Param("name") String name);

    //分页查询相关数据
    List<UserVO> userSelectList(@Param("classNo") String classNo,
                                     @Param("name") String name,
                                     @Param("offset") Integer offset,
                                     @Param("pageSize") Integer pageSize);

    //根据用户名查询个人信息功能
    @Select("select * from users where username=#{username}")
    Users getUserByUsername(String username);

    //新增功能
    @Insert("insert into users(id, nickname, username, password, birthday, tel, identity, email, address, size, is_admin) values(null, #{nickname}, #{username}, #{password}, #{birthday}, #{tel}, #{identity}, #{email}, #{address}, #{size}, 0)")
    int addUser(Users users);

    //判断用户是否存在
    @Select("select * from users where username=#{username} and is_admin=0")
    Users checkUsername(String username);
}