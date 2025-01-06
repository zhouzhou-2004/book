package com.book.book.mapper;


import com.book.book.model.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Description 借阅管理
 * @Date 2020/7/15 16:45
 * @Author by
 */

public interface BorrowMapper {
/**
 * 第一个页面：搜索图书
 */
//功能1：获取所有图书信息
    List<Book> selectBooKAll();

//功能2：根据图书名称搜索图书
//    @Select("select * from book where name like concat('%',#{name},'%') and is_delete = 0")
    List<Book> searchBook(String name);

//    功能3：分页查询
    /**
     * 统计总记录数
     */
    Long selectTotal(@Param("classNo") String classNo,
                     @Param("name") String name);
    /**
     * 分页查询相关数据
     */
    List<Book> selectBookPage(@Param("classNo") String classNo,
                             @Param("name") String name,
                             @Param("offset") Integer offset,
                             @Param("pageSize") Integer pageSize);
/**
 * 第二个页面：借阅图书
 */

/**
 *第三个页面：归还图书
 */

}