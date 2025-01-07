package com.book.book.controller;

import com.book.book.model.dto.QueryRequest;
import com.book.book.model.dto.UsersDto;
import com.book.book.model.pojo.Users;
import com.book.book.model.vo.UserVO;
import com.book.book.service.UsersService;
import com.book.book.utils.PageResult;
import com.book.book.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersService usersService;

    /**
     * 获取所有用户
     */
    @RequestMapping("/list/select")
    private ResponseUtils getAllUser(){
        try {
            List<UserVO> allUser = usersService.getAllUser();
//        System.out.println("查询出来的结果:"+allUser);
//        return null;
            if (allUser == null){
                //查询为空(失败)
                return new ResponseUtils(500,"查询失败");
            }else {
                //查询成功
                return new ResponseUtils(200,"查询成功",allUser);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils(400,"查询异常");
        }
    }

    /**
     * 模糊查询(用户名或昵称)
     */
    @RequestMapping("/list/selectLike")
    public ResponseUtils selectLike(@RequestBody QueryRequest queryRequest) {
        PageResult<UserVO> result = usersService.selectLikeWithPage(queryRequest);
        return new ResponseUtils(200, "success", result);
    }

    /**
     *  修改功能
     */
    @RequestMapping("/list/update")
    private ResponseUtils update(@RequestBody UserVO userVO){
        try {
            int updatedUser = usersService.updateUser(userVO);
            if (updatedUser == 1){
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
    @RequestMapping("/list/delete")
    private ResponseUtils delete(@RequestBody UserVO userVO){
        try {
            int deleted = usersService.deleteUser(userVO.getId());
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

    /**
     * 分页查询
     */
    @RequestMapping("/list/page")
    private ResponseUtils list(@RequestBody QueryRequest queryRequest){
        PageResult<UserVO> tStudentPageResult = usersService.userSelectList(queryRequest);
        return new ResponseUtils(200,"success",tStudentPageResult);
    }

    /**
     * 根据用户名查询个人信息功能
     */
    @RequestMapping("/info")
    private ResponseUtils info(@RequestBody Users users){
        System.out.println(users);
        try {
            Users userById = usersService.getUserByUsername(users.getUsername());
            if (userById != null){
                return new ResponseUtils(200,"查询成功",userById);
            }else {
                return new ResponseUtils(400,"查询失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException();
        }
    }

    /**
     * 添加功能
     */
    @RequestMapping("/add")
    private ResponseUtils add(@RequestBody Users users){
        try {
            int addUser = usersService.addUser(users);
            if (addUser == 1){
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
    @RequestMapping("/checkUsername")
    private ResponseUtils checkUsername(@RequestBody Users users){
        try {
            int checked = usersService.checkUsername(users.getUsername());
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
}

