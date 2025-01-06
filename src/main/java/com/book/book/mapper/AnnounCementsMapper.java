package com.book.book.mapper;

import com.book.book.model.pojo.Announcements;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AnnounCementsMapper {
    // 查询所有公告
    @Select("SELECT * FROM announcements where is_delete = 0")
    List<Announcements> selectAllNotices();

    // 查询单个公告
    @Select("SELECT * FROM  announcements WHERE id = #{id} and is_delete = 0")
    Announcements selectNoticeById(Integer id);

    // 插入新公告
//    @Insert("INSERT INTO announcements (null,title, status, publish_time, publisher, preview) VALUES (#{title}, #{status}, now(), #{publisher},#{preview},0)")
    @Insert("insert into announcements values (null,#{title}, #{status}, now(), #{publisher},#{preview},0)")
    int insertNotice(Announcements notice);


    // 删除公告
    @Update("update announcements set is_delete = 1 WHERE id = #{id}")

    int deleteNoticeById(int id);

    // 根据关键词搜索公告（简单示例，可根据实际需求优化）
//    @Select("SELECT * FROM announcements WHERE title LIKE '%${keyword}%' OR preview LIKE '%${keyword}%'")
//    List<Announcements> searchAnnouncements(String keyword);
}
