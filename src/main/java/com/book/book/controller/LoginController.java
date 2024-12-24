package com.book.book.controller;


import com.book.book.mapper.userMapper;
import com.book.book.model.pojo.Users;
import com.book.book.service_dx.LoginService;
import com.book.book.utils.ResponseUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tAdmin")
public class LoginController {

    //董的登录后端

    //登录功能
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody
    public ResponseUtils login(@RequestBody Users users , HttpServletResponse response, HttpServletRequest request){
        //1.获取参数
        System.out.println(users.getUsername());
        System.out.println(users.getPassword());
        try {
            //将后端存储到服务器上面的Session验证码取出来
            HttpSession session = request.getSession();
            String verificationcode = (String) session.getAttribute("verificationcode");
            System.out.println("前端发送过来的参数"+users);
            Users userLogin = loginService.login(users);
            System.out.println("从数据库中查询出来的数据"+userLogin);
            String userCode = users.getCode();
              if (userLogin == null){
                  return new ResponseUtils<>(306, "登录失败");
              }else {
                  if (verificationcode.equalsIgnoreCase(userCode)) {
                      return new ResponseUtils<>(200, "登录成功");
                  } else {
                      return new ResponseUtils<>(500, "验证码错误");
                  }
              }
          } catch (Exception e) {
            e.printStackTrace();//打印错误报告
            return new ResponseUtils<>(500, "数据异常,登录失败");

        }
    }
}
