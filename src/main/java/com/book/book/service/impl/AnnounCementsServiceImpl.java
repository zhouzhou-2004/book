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

    @Override
    public List<Announcements> selectAllNotices() {
        List<Announcements> announcements = announCementsMapper.selectAllNotices();
        if (announcements != null){
            return announcements;
        }else {
            return null;
        }
    }
}
