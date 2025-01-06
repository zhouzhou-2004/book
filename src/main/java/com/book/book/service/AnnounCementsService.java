package com.book.book.service;

import com.book.book.model.pojo.Announcements;

import java.util.List;

public interface AnnounCementsService {
    //查询所有公告
    List<Announcements> selectAllNotices();

    //查看单个公告详情的方法
    Announcements getAnnouncementById(Integer id);

    //添加公告
    int insertNotice(Announcements announcements);


    //删除公告
    int deleteNotice(int id);
}
