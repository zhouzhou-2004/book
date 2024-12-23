package com.book.book.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Description 图书
 * @Date 2020/7/14 19:57
 * @Author by
 */
@Mapper
@Component
public interface BookMapper {

    /**
     * 模糊分页查询用户
     * @param keyword 关键字
     * @return
     */
    //List<Book> findBookListByLike(String keyword);

    /**
     * 编辑用户
     * @param map
     * @return
     */
    //int updateBook(Map<String, Object> map);
}
