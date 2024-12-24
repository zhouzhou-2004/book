package com.book.book.controller;


import com.book.book.model.dto.queryRequest.QueryRequest;
import com.book.book.model.pojo.Users;
import com.book.book.service.ReaderService;

import com.book.book.utils.PageResult;
import com.book.book.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reader")
public class ReaderController {
    @Autowired
    private ReaderService readerService;

    @RequestMapping("/list")
    public ResponseUtils list (@RequestBody QueryRequest queryRequest){
        PageResult<Users> usersPageResult = readerService.selectReaderList(queryRequest);
        return new ResponseUtils(200,"success",usersPageResult);
    }

//    @RequestMapping("/like")
//    public ResponseUtils selectByLike(@RequestBody Users users){
//        try {
//            //参数拿到之后，我们应该去干嘛
//            List<Users> tAdmins = readerService.selectByLike(users.getNickname());
//            if (tAdmins != null){
//                return new ResponseUtils(200,"查询成功",tAdmins);
//            }else {
//                return new ResponseUtils(400,"查询失败");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }
}
