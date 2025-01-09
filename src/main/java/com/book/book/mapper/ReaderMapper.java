package com.book.book.mapper;

import com.book.book.model.pojo.Users;
import com.book.book.model.vo.UserVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.io.Reader;
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
    @Select("SELECT * FROM users WHERE (username LIKE CONCAT('%',#{likeName},'%') OR nickname LIKE CONCAT('%',#{likeName},'%')) AND is_admin=0")
    List<UserVO> selectByLike(@Param("likeName") String likeName);
    //新增功能
    @Insert("insert into users(id, nickname, username, password, birthday, tel, identity, email, address, size, is_admin) values(null, #{nickname}, #{username}, #{password}, #{birthday}, #{tel}, #{identity}, #{email}, #{address}, #{size}, 0)")
    int addReader(Users users);

    //判断用户是否存在
    @Select("select * from users where username=#{username} and is_admin=0")
    Users checkReaderName(String username);

    //根据id修改管理员功能
    @Update("update users set nickname=#{nickname},username=#{username},birthday=#{birthday},tel=#{tel},email=#{email},address=#{address},size=#{size},identity=#{identity} where id=#{id}")
    int updateReader(UserVO userVO);

    //删除功能
    @Update("update users set is_admin = 1 where id=#{id}")
    int deleteReader(int id);

    //批量删除
    @Update("<script>" +
            "UPDATE users SET is_admin = 1 WHERE id IN " +
            "<foreach item='id' index='index' collection='id' open='(' separator=',' close=')'>" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    int deleteReadersById(@Param("id") List<Long> id);
}
