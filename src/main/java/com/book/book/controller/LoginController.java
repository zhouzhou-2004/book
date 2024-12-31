package com.book.book.controller;


import com.book.book.model.pojo.Users;
import com.book.book.service.LoginService;
import com.book.book.utils.ResponseUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;

@RestController
@RequestMapping("/tAdmin")
public class LoginController {
    //

    //董的登录后端

    @Autowired
    private LoginService loginService;

    //检查用户名是否重复
    @RequestMapping("checkUserName")
    public ResponseUtils checkUserName(@RequestBody  Users users){
        try {
            System.out.println("前端发送过来的参数"+users);
            Users user = loginService.checkName(users);
            System.out.println("从数据库中查询出来的数据"+user);
            if (user == null){
                return  new ResponseUtils<>(200,"数据库中不存在此账号,该账号可用");
            }else {
                System.out.println("该账号在数据库");
                return new ResponseUtils<>(305,"该账号已经存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils<>(400,"数据库异常");
        }
    }



    //登录功能
    @RequestMapping("/login")
    @ResponseBody
    public ResponseUtils login(@RequestBody Users users , HttpServletResponse response, HttpServletRequest request) {
        //1.获取参数
        System.out.println(users.getUsername());
        System.out.println(users.getPassword());
        try {
                //将后端存储到服务器上面的Session验证码取出来
                HttpSession session = request.getSession();
                String verificationcode = (String) session.getAttribute("verificationcode");
                System.out.println("前端发送过来的参数" + users);
                Users userLogin = loginService.login(users);
                System.out.println("从数据库中查询出来的数据" + userLogin);
                String userCode = users.getCode();
                if (userLogin == null) {
                    //登录失败
                    return new ResponseUtils<>(306, "登录失败");
                } else {
                    if (verificationcode.equalsIgnoreCase(userCode)) {
                        //验证码正确,登录成功
                        //是否勾选记住我
                        System.out.println(userLogin.isRemember());
                        if (userLogin.isRemember()) {
                            //勾选记住
                            //存储当前的用户名和密码到cookie中
                            Cookie cookie1 = new Cookie("Name", URLEncoder.encode(userLogin.getUsername(), "UTF-8"));
                            Cookie cookie2 = new Cookie("Pass", URLEncoder.encode(userLogin.getPassword(), "UTF-8"));
                            //设置cookie的存活时间
                            cookie1.setMaxAge(60 * 60 * 24 * 7);
                            cookie2.setMaxAge(60 * 60 * 24 * 7);
                            response.addCookie(cookie1);
                            response.addCookie(cookie2);
                            //设置cookie的路径,使其在整个应用中可用
                            cookie1.setPath("/");
                            cookie2.setPath("/");
                        }
                        //获取用户信息,拦截器
                        session.setAttribute("userLogin",userLogin);
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



    //注册功能
    @RequestMapping("/register")
    @ResponseBody
    public ResponseUtils register(@RequestBody Users users ,HttpServletRequest request) {
        //1.获取参数
//        System.out.println(users.getUsername());
//        System.out.println(users.getPassword());
        //2.添加到数据库
        //先拿到用户输入的验证码是否正确,再去操作数据库
        //拿到用户输入的验证码和Session储存的验证码
        HttpSession session = request.getSession();
        System.out.println("用户输入的验证码"+users.getVerifyCode());
        String uuiDcode = (String) session.getAttribute("UUIDcode");
        System.out.println("系统生成的验证码"+uuiDcode);
        try {
            if (users.getVerifyCode().equals(uuiDcode)){
                int result = loginService.register(users);
                return (result == 1) ? new ResponseUtils<String>(200,"注册成功") : new ResponseUtils<String>(500,"注册失败");
            }else {
                return new ResponseUtils<String>(500,"手机验证码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();//打印错误报告
            return new ResponseUtils<String>(500,"数据异常,注册失败");

        }
    }

    //退出登录功能
    @RequestMapping("logout")
    @ResponseBody
    public ResponseUtils logout(HttpServletResponse response, HttpServletRequest request) {
        try {
            // 获取当前会话
            HttpSession session = request.getSession(false);
            if (session != null) {
                // 清除会话中的用户信息
                session.removeAttribute("userLogin");
                // 使整个会话失效
                session.invalidate();
            }

            // 删除与用户相关的Cookie
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("Name".equals(cookie.getName()) || "Pass".equals(cookie.getName())) {
                        cookie.setValue("");
                        cookie.setPath("/");
                        cookie.setMaxAge(0); // 设置为0表示立即删除
                        response.addCookie(cookie);
                    }
                }
            }

            return new ResponseUtils<>(200, "退出成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils<>(500, "退出失败");
        }
    }

    //手机号验证码
    @RequestMapping("/sendCode")
    @ResponseBody
    public ResponseUtils sendCode(@RequestBody Users users,HttpServletRequest request){
       //        手机号与用户绑定
        Users result = loginService.selectPhone(users.getTel(),request);
        if (result == null){
            System.out.println("验证码来了");
            return new ResponseUtils<>(200,"验证码已发送");
        }else {
            return new ResponseUtils<>(500,"手机号已被注册");
        }
    }
}

