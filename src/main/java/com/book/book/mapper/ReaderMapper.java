package com.book.book.mapper;

import com.book.book.model.pojo.Users;
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
    List<Users> selectReaderList(
                                     @Param("offset") Integer offset,
                                     @Param("pageSize") Integer pageSize);
//    /**
//     * 模糊查询
//     */
//    @Select(" SELECT * FROM users where username like concat('%',#{likeName},'%')")
//    List<Users> selectByLike(String likeName);
}
