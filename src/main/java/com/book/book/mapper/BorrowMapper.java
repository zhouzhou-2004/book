package com.book.book.mapper;


import com.book.book.model.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

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
    @Select("select * from book where is_delete = 0")
    List<Book> selectBooKAll();

//功能3：删除图书
    @Update("update book set is_delete = 1 where id = #{id}")
    int deleteBook(int id);

/**
 * 第二个页面：借阅图书
 */

/**
 *第三个页面：归还图书
 */

}