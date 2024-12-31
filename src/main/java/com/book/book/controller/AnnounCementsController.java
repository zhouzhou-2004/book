package com.book.book.controller;

import com.book.book.model.pojo.Announcements;
import com.book.book.service.AnnounCementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library_notice")
public class AnnounCementsController {
    @Autowired
    private AnnounCementsService announCementsService;

    // 获取所有公告
    @RequestMapping("/all")
    public List<Announcements> selectAllNotices(){
        try {
            List<Announcements> announcements = announCementsService.selectAllNotices();
            System.out.println(announcements);
            if(announcements != null){
                return announcements;
            }else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    // 根据ID获取公告
//    @GetMapping("/{id}")
//    public LibraryNotice getNoticeById(@PathVariable("id") Integer id) {
//        return libraryNoticeService.getNoticeById(id);
//    }

    // 新增公告
//    @PostMapping("/add")
//    public void addNotice(@RequestBody LibraryNotice notice) {
//        libraryNoticeService.addNotice(notice);
//    }

    // 更新公告
//    @PutMapping("/update")
//    public void updateNotice(@RequestBody LibraryNotice notice) {
//        libraryNoticeService.updateNotice(notice);
//    }

    // 删除公告
//    @DeleteMapping("/{id}")
//    public void deleteNotice(@PathVariable("id") Integer id) {
//        libraryNoticeService.deleteNotice(id);
//    }
}
