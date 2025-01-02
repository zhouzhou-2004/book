package com.book.book.service.impl;

import com.book.book.mapper.AnnounCementsMapper;
import com.book.book.model.pojo.Announcements;
import com.book.book.model.pojo.LibraryInfo;
import com.book.book.service.AnnounCementsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AnnounCementsServiceImpl implements AnnounCementsService {

    @Autowired
    private AnnounCementsMapper announCementsMapper;

    //查询所有公告
    @Override
    public List<Announcements> selectAllNotices() {
        List<Announcements> announcements = announCementsMapper.selectAllNotices();
        if (announcements != null){
            return announcements;
        }else {
            return null;
        }
    }

    //添加公告
    @Override
    public int insertNotice(Announcements announcements) {
        try {
            int insert = announCementsMapper.insertNotice(announcements);
            if(insert > 0){
                return 1;//添加成功 result > 0
            }else {
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

    //删除公告
    @Override
    public int deleteNotice(int id) {
        try {
            int i = announCementsMapper.deleteNoticeById(id);
            if(i != 0){
                return 1;//删除成功
            }else {
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }
}
