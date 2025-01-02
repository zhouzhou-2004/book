package com.book.book.mapper;

import com.book.book.model.pojo.Users;
import com.book.book.model.vo.UserVO;
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
}
