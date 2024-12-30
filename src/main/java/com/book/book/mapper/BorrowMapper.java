package com.book.book.mapper;


import com.book.book.model.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description 借阅管理
 * @Date 2020/7/15 16:45
 * @Author by
 */
@Mapper
public interface BorrowMapper {
/**
 * 第一个页面：搜索图书
 */
//功能1：获取所有图书信息
//    @Select("select * from book")
    List<Book> selectBooKAll();

//功能2：输入书名查询图书
/**
 * 第二个页面：借阅图书
 */
/**
 *第三个页面：归还图书
 */

}