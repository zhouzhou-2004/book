package com.book.book.mapper;

import com.book.book.model.pojo.Users;
import com.book.book.model.vo.UserVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ReaderMapper {

    /**
     * 统计总记录数
     */
    Long selectTotal(@Param("classNo") String classNo,
                     @Param("name") String name);
    /**
     * 分页查询相关数据
     */


    List<UserVO> selectReaderList(
            @Param("offset") Integer offset,
            @Param("pageSize") Integer pageSize,
            @Param("classNo") String classNo,
            @Param("name") String name
    );

    /**
     * 模糊查询
     */

    @Select("select * from users where username like concat('%',#{username},'%') or nickname  like concat('%',#{username},'%') and is_admin=0")
    List<UserVO> selectByLike(String LikeName);

    //新增功能
    @Insert("insert into users(id, nickname, username, password, birthday, tel, identity, email, address, size, is_admin) values(null, #{nickname}, #{username}, #{password}, #{birthday}, #{tel}, #{identity}, #{email}, #{address}, #{size}, 0)")
    int addReader(Users users);

    //判断用户是否存在
    @Select("select * from users where username=#{username} and is_admin=0")
    Users checkReaderName(String username);
}
