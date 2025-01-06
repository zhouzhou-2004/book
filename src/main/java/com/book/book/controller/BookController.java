package com.book.book.controller;

import com.book.book.model.pojo.Book;
import com.book.book.model.vo.UserVO;
import com.book.book.service.BookService;
import com.book.book.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description 用户管理
 * @Date 2024/12/23 20：00
 * @Author by
 */

@RestController
@RequestMapping("/GetBook")
public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping("/selectBook")
    public ResponseUtils BookAll() {
        try {
            List<Book> books = bookService.BookAll();
            System.out.println("查询结果：");
            books.forEach(book -> System.out.println(book.toString()));

            if (books == null || books.isEmpty()) {
                return new ResponseUtils(500, "查询失败");
            } else {
                return new ResponseUtils(200, "查询成功", books);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils(400, "查询异常");
        }
    }
    /**
     * 编辑图书信息
     */
    @PostMapping("/updateBook")
    public ResponseUtils updateBook(@RequestBody(required = false) Book book) {
        try {
            // 打印接收到的数据，方便调试
            System.out.println("接收到的更新数据：" + book);

            // 参数校验
            if (book == null) {
                return new ResponseUtils(400, "参数错误：请求体为空");
            }

            Integer bookId = book.getId();
            if (bookId == null) {
                return new ResponseUtils(400, "参数错误：图书ID不能为空");
            }

            // 调用服务层更新数据
            int result = bookService.updateBook(book);

            // 根据更新结果返回不同的响应
            if (result > 0) {
                return new ResponseUtils(200, "图书信息更新成功");
            } else {
                return new ResponseUtils(500, "图书信息更新失败，请检查图书ID是否存在");
            }

        } catch (Exception e) {
            // 打印详细错误信息
            e.printStackTrace();
            return new ResponseUtils(400, "更新异常：" + e.getMessage());
        }
    }
    //删除图书信息
    @PostMapping("/deleteBook")
    private ResponseUtils delete(@RequestBody Book book){
        try {
            //拿到参数之后我们就可以去执行SQL删除用户了
            int deleted = bookService.deleteBook(book.getId());  // 使用注入的 bookService
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
