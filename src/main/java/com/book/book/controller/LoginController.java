//package com.book.book.controller;
//
//
//import com.book.book.utils.ResponseUtils;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/login")
//public class LoginController {
//
//    //董的登录后端
//
//    //登录功能
//    public ResponseUtils<String> login(@RequestBody TAdmin tAdmin , HttpServletRequest request){
//        //1.获取参数
//        System.out.println(tAdmin.getUsername());
//        System.out.println(tAdmin.getPassword());
//        //2.添加到数据库
//        try {
//            //将后端存储到服务器上面的Session验证码取出来
//            HttpSession session = request.getSession();
//            String verificationcode = (String) session.getAttribute("verificationcode");
//            String userCode = tAdmin.getCode();
//            if (verificationcode.equalsIgnoreCase(userCode)){
//                int result = tAdminService.register(tAdmin);
//                return (result== 1) ? new ResponseUtils<String>(200,"登录成功") : new ResponseUtils<String>(500,"注册失败");
//
//            }else {
//                return new ResponseUtils<String>(500,"验证码错误");
//            }
//          } catch (Exception e) {
//            e.printStackTrace();//打印错误报告
//            return new ResponseUtils<String>(500,"数据异常,登录失败");
//
//        }
//    }
//}
