package com.book.book.controller;

import com.book.book.utils.ResponseUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class userController {
    @RequestMapping("/list")
    private ResponseUtils list(){
        System.out.println("list");
        return null;
    }
}
