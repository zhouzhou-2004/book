package com.book.book.controller;

import com.book.book.model.pojo.Users;
import com.book.book.model.vo.UserVO;
import com.book.book.service.UserService;
import com.book.book.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/list")
    public ResponseUtils<List<UserVO>> list() {
        try {
            List<UserVO> allUser = userService.getAllUser();
            System.out.println("查询结果：" + allUser);
            if (allUser != null) {
                return new ResponseUtils<>(200, "查询成功", allUser);
            } else {
                return new ResponseUtils<>(500, "查询失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils<>(400, "查询异常");
        }
    }
}
