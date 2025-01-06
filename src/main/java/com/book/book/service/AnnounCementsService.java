package com.book.book.service;

import com.book.book.model.pojo.Announcements;

import java.util.List;

public interface AnnounCementsService {
    //查询所有公告
    List<Announcements> selectAllNotices();

    //根据id查询公告
    //LibraryNotice getNoticeById(Integer id);

    //添加公告
    int insertNotice(Announcements announcements);

    //更新公告
    //void updateNotice(LibraryNotice notice);

    //删除公告
    int deleteNotice(int id);
}
