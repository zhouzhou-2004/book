package com.book.book.mapper;

import com.book.book.model.pojo.Announcements;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AnnounCementsMapper {
    // 查询所有公告
    @Select("SELECT * FROM announcements")
    List<Announcements> selectAllNotices();

    // 根据ID查询公告
    @Select("SELECT * FROM  announcements WHERE id = #{id}")
    Announcements selectNoticeById(Integer id);

    // 插入新公告
    //@Insert("INSERT INTO announcements (title, content, create_time, update_time) VALUES (#{title}, #{content}, #{createTime}, #{updateTime})")
    //int insertNotice(Announcements notice);

    // 更新公告
    //@Update("UPDATE announcements\n" + "SET title = #{title}, content = #{content}, update_time = #{updateTime}\n" + " WHERE id = #{id}")
    //int updateNotice(Announcements notice);

    // 删除公告
    //@Delete("DELETE FROM library_notice WHERE id = #{id}")
    //int deleteNoticeById(Integer id);
}
