package com.book.book.controller;

import com.book.book.model.pojo.Book;
import com.book.book.service.BorrowService;
import com.book.book.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description 用户管理
 * @Date 2024/12/23 16:35
 * @Author by
 */
@RestController
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;
/**
 * 搜索图书页面
 */
//获取所有图书信息
    @RequestMapping("/select")
    public ResponseUtils selectBookAll(){
//        System.out.print("111");
//        return null;
        //前端没有携带参数，直接操作数据库
        try {
            List<Book> books = borrowService.selectBooKAll();
////        查询出来的结果
            System.out.println("查询出来的结果"+books);
            if (books == null) {
    //            查询为空
                return new ResponseUtils(500, "查询失败");
            }else {
    //            查询成功
                return new ResponseUtils(200, "查询成功", books);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils(400,"删除异常");
        }
    }

    /**
     * 删除图书
     */
//        @RequestMapping("/delete")
//        public ResponseUtils deleteBook(@RequestBody BookLogin bookLogin) {
//            try {
//                //拿到参数之后我们就可以去执行sql删除用户了
//                int result = borrowService.deleteBook(bookLogin.getId());
//                if (result == 1){
//                    //删除成功
//                    return new ResponseUtils(200,"删除成功");
//                }else {
//                    return new ResponseUtils(500,"删除失败");
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//                return new ResponseUtils(400,"删除异常");
//            }
//        }
}
