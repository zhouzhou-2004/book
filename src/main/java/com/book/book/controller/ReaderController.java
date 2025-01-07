package com.book.book.controller;


import com.book.book.model.dto.QueryRequest;
import com.book.book.model.dto.UsersDto;
import com.book.book.model.pojo.Users;
import com.book.book.model.vo.UserVO;
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
    private ResponseUtils selectReaderList(@RequestBody QueryRequest queryRequest) {
        try {
            PageResult<UserVO> userVO = readerService.selectReaderList(queryRequest);
            if (userVO == null) {
                //查询为空(失败)
                return new ResponseUtils(500, "查询失败");
            } else {
                //查询成功
                return new ResponseUtils(200, "查询成功", userVO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils(400, "查询异常");
        }
    }
    @RequestMapping("/selectLike")
    public ResponseUtils selectByLike(@RequestBody UsersDto usersDto){
        try {
            //参数拿到之后，我们应该去干嘛
            List<UserVO> userVO = readerService.selectByLike(usersDto.getUserText());
            if (userVO != null){
                return new ResponseUtils(200,"查询成功",userVO);
            }else {
                return new ResponseUtils(400,"查询失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils(500,"查询失败");
        }
    }

    /**
     * 添加功能
     */
    @RequestMapping("/add")
    private ResponseUtils add(@RequestBody Users users){
        try {
            int addReader = readerService.addReader(users);
            if (addReader == 1){
                return new ResponseUtils(200,"添加成功");
            }else {
                return new ResponseUtils(500,"添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils(400,"添加异常");
        }
    }

    /**
     * 判断用户是否存在
     */
    @RequestMapping("/checkReaderName")
    private ResponseUtils checkUsername(@RequestBody Users users){
        try {
            int checked = readerService.checkReaderName(users.getUsername());
            if (checked == 1){
                return new ResponseUtils(305,"该用户名存在");
            }else {
                return new ResponseUtils(200,"该用户名可用");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException();
        }
    }

    /**
     *  编辑
     */
    @RequestMapping("/update")
    private ResponseUtils updateReader(@RequestBody UserVO userVO){
        try {
            int updateReader = readerService.updateReader(userVO);
            if (updateReader == 1){
                return new ResponseUtils(200,"修改成功");
            }else {
                return new ResponseUtils(500,"修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils(400,"修改异常");
        }
    }

    /**
     * 删除功能
     */
    @RequestMapping("/delete")
    private ResponseUtils deleteReader(@RequestBody UserVO userVO){
        try {
            int deleted = readerService.deleteReader(userVO.getId());
            if (deleted == 1){
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
