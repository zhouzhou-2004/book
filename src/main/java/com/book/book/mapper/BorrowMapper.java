package com.book.book.mapper;


import com.book.book.model.pojo.Book;
import com.book.book.model.pojo.Borrow;
import org.apache.ibatis.annotations.Param;

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
// 检查用户是否存在
    int checkUserExists(Integer userId);
    // 获取用户当前借阅数量
    int getUserBorrowCount(Integer userId);
    // 根据书名和作者查询图书
    Book getBookByNameAndAuthor(@Param("name") String name, @Param("author") String author);

    // 更新图书库存
    int updateBookStock(@Param("bookId") Integer bookId);

    // 添加借阅记录
    int insertBorrow(Borrow borrow);
/**
 *第三个页面：归还图书
 */

}