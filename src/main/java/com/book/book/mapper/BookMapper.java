package com.book.book.mapper;

import com.book.book.model.pojo.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @Description 图书
 * @Date 2020/7/14 19:57
 * @Author by
 */
@Mapper
@Component
public interface BookMapper {
//查询所有图书
    @Select("select * from book where is_delete = 0")
    List<Book> BookAll();
//    编辑图书信息
    @Update("update book set name=#{name},author=#{author},isbn=#{isbn},pages=#{pages},price=#{price},publish=#{publish},publish_time=#{publishTime},size=#{size},type = #{type} where id=#{id}")
    int updateBook(Book book);
    //    删除图书
    @Update("update book set is_delete = 1 where id=#{id}")
    int deleteBook(int id);
    // 添加图书
    @Insert("INSERT INTO book (name, author, isbn, pages, price, publish, " +
            "publish_time, size, type, is_delete) " +
            "VALUES (CONCAT('《', #{name}, '》'), #{author}, #{isbn}, " +
            "#{pages}, #{price}, #{publish}, #{publishTime}, #{size}, #{type}, 0)")
    int addBook(Book book);
    // 按书名搜索
    @Select("SELECT * FROM book WHERE name LIKE CONCAT('%',#{keyword},'%') AND is_delete = 0")
    List<Book> searchByName(String keyword);

    // 按作者搜索
    @Select("SELECT * FROM book WHERE author LIKE CONCAT('%',#{keyword},'%') AND is_delete = 0")
    List<Book> searchByAuthor(String keyword);

    // 按ISBN搜索
    @Select("SELECT * FROM book WHERE isbn LIKE CONCAT('%',#{keyword},'%') AND is_delete = 0")
    List<Book> searchByIsbn(String keyword);
}
