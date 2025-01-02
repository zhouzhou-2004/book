package com.book.book.controller;


import com.book.book.model.dto.BookLogin;
import com.book.book.model.dto.QueryRequest;
import com.book.book.model.pojo.Book;
import com.book.book.service.BorrowService;
import com.book.book.utils.PageResult;
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
     * 搜索图书
     */
    @RequestMapping("/search")
    public ResponseUtils searchBook(@RequestBody BookLogin bookLogin){
        try {
            List<Book> books = borrowService.searchBook(bookLogin.getName());
            System.out.println(books);
            if (books != null) {
                return new ResponseUtils(200, "查询成功", books);
            } else {
                return new ResponseUtils(400, "查询失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
    /**
     * 分页查询
     */

    @RequestMapping("/page")
    public ResponseUtils list(@RequestBody QueryRequest queryRequest){
        PageResult<Book> BookPageResult = borrowService.selectBookPage(queryRequest);
        return new ResponseUtils(200,"success",BookPageResult);
    }

    /**
     * 删除图书
     */
}
