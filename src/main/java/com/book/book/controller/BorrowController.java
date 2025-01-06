package com.book.book.controller;


import com.book.book.model.dto.BookLogin;
import com.book.book.model.dto.QueryRequest;
import com.book.book.model.pojo.Book;

import com.book.book.service.BookService;
import com.book.book.service.BorrowService;
import com.book.book.utils.PageResult;
import com.book.book.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;
import java.util.Optional;

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
//        查询出来的结果
//            System.out.println("查询出来的结果"+books);
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
//            System.out.println(books);
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
    //删除图书信息
    @PostMapping("/deleteBook")
    private ResponseUtils delete(@RequestBody Book book){
        try {
            //拿到参数之后我们就可以去执行SQL删除用户了
            int deleted = borrowService.deleteBook(book.getId());  // 使用注入的 bookService
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
    @PostMapping("/addBook")
    private ResponseUtils add(@RequestBody Book book) {
        try {
            int result = borrowService.addBook(book);
            if (result == 1) {
                return new ResponseUtils(200, "添加成功");
            } else {
                return new ResponseUtils(500, "添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils(400, "添加异常");
        }
    }
    /**
     * 借阅图书
     */
    //验证用户ID是否存在并获取当前借阅数量
    @PostMapping("/getUserBorrowCount")
    public ResponseUtils checkUserId(@RequestBody Map<String, Integer> params) {
        try {
            Integer userId = params.get("userId");
            if (userId == null) {
                return new ResponseUtils(400, "用户ID不能为空");
            }

            // 检查用户是否存在
            if (!borrowService.checkUserExists(userId)) {
                return new ResponseUtils(400, "用户不存在");
            }

            // 获取用户当前借阅数量
            int borrowCount = borrowService.getUserBorrowCount(userId);
            return new ResponseUtils(200, "查询成功", Optional.of(borrowCount));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils(500, "系统错误");
        }
    }

    @PostMapping("/borrowBook")
    public ResponseUtils borrowBook(@RequestBody Map<String, Object> params) {
        try {
            // 参数验证
            if (params == null ||
                    params.get("userId") == null ||
                    params.get("bookName") == null ||
                    params.get("author") == null ||
                    params.get("borrowTime") == null ||
                    params.get("returnTime") == null) {
                return new ResponseUtils(400, "请求参数不完整");
            }

            // 安全的类型转换
            Integer userId;
            try {
                Object userIdObj = params.get("userId");
                if (userIdObj instanceof Integer) {
                    userId = (Integer) userIdObj;
                } else if (userIdObj instanceof String) {
                    userId = Integer.parseInt((String) userIdObj);
                } else {
                    return new ResponseUtils(400, "用户ID格式错误");
                }
            } catch (NumberFormatException e) {
                return new ResponseUtils(400, "用户ID必须为数字");
            }

            String bookName = String.valueOf(params.get("bookName"));
            String author = String.valueOf(params.get("author"));
            String borrowTime = String.valueOf(params.get("borrowTime"));
            String returnTime = String.valueOf(params.get("returnTime"));

            // 调用服务层方法执行借阅
            Map<String, Object> result = borrowService.borrowBook(userId, bookName, author, borrowTime, returnTime);

            if ((Boolean) result.get("success")) {
                return new ResponseUtils(200, "借阅成功");
            } else {
                return new ResponseUtils(400, (String) result.get("message"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils(500, "系统错误：" + e.getMessage());
        }
    }
    @PostMapping("/getBook")
    public ResponseUtils getBook(@RequestBody Map<String, Integer> params) {
        try {
            Integer id = params.get("id");
            if (id == null) {
                return new ResponseUtils(400, "图书ID不能为空");
            }
            Book book = borrowService.getBookById(id);
            if (book != null) {
                return new ResponseUtils(200, "查询成功", book);
            } else {
                return new ResponseUtils(404, "图书不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils(500, "系统错误");
        }
    }
}
