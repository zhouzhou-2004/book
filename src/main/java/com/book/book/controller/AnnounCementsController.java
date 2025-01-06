package com.book.book.controller;

import com.book.book.model.pojo.Announcements;
import com.book.book.model.pojo.Users;
import com.book.book.service.AnnounCementsService;
import com.book.book.service.LoginService;
import com.book.book.service.UsersService;
import com.book.book.utils.ResponseUtils;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/library_notice")
public class AnnounCementsController {
    @Autowired
    private AnnounCementsService announCementsService;
    @Autowired
    private LoginService loginService;
    // 获取所有公告
    @RequestMapping("/all")
    public ResponseUtils selectAllNotices(){
        try {
            List<Announcements> announcements = announCementsService.selectAllNotices();
            System.out.println(announcements);
            if(announcements != null){
                return new ResponseUtils<>(200,"查询成功",announcements);
            }else {
                return new ResponseUtils<>(400,"查询失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    // 新增公告
    @RequestMapping("/add")
    public Map<String, Object> addNotice(@RequestBody Announcements announcements, HttpSession session) {
        //System.out.println(announcements);
        try {
            // 获取当前登录用户
            Users userLogin = (Users) session.getAttribute("userLogin");
            if (userLogin == null) {
                return Map.of("code", 401, "message", "用户未登录");
            }

            // 设置发布人为当前登录用户名
            announcements.setPublisher(userLogin.getUsername());
            //插入新公告
            int insert = announCementsService.insertNotice(announcements);

            if(insert > 0){
                // 返回成功信息以及新公告的详细信息
                Map<String, Object> resultMap = new HashMap<>();
                resultMap.put("code", 200);
                resultMap.put("message", "新增成功");
                resultMap.put("data", announcements); // 确保返回的公告对象包含了 publish_time
                return resultMap;
            }else {
                return Map.of("code", 500, "message", "新增失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Map.of("code", 400, "message", "新增异常");
        }
    }

    // 更新公告
//    @PutMapping("/update")
//    public void updateNotice(@RequestBody LibraryNotice notice) {
//        libraryNoticeService.updateNotice(notice);
//    }

    // 删除公告
    @RequestMapping("/delete")
    public ResponseUtils delete(@RequestBody Announcements announcements){
        try {
            //拿到参数就可以执行SQL删除公告了
            int result = announCementsService.deleteNotice(announcements.getId());
            if(result == 1){
                return new ResponseUtils(200,"删除成功");
            }else {
                return new ResponseUtils(500,"删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils(400,"删除异常");
        }
    }
}
