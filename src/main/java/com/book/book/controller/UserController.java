package com.book.book.controller;

import com.book.book.model.pojo.Users;
import com.book.book.service.UserService;
import com.book.book.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/list")
    private ResponseUtils list(){
        try {
            List<Users> allUser = userService.getAllUser();
            if (allUser != null){
                //查询成功
                return new ResponseUtils(200,"查询成功",allUser);
            }else {
                //查询为空(失败)
                return new ResponseUtils(500,"查询失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils(400,"查询异常");
        }
    }
}
