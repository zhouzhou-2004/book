package com.book.book.interceptor;

import com.book.book.model.pojo.Users;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {

    //dx 拦截器逻辑
    //
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.先session中拿到刚才登录成功时储存的Session的值
        HttpSession session = request.getSession();
        //如果两个用户或者多个用户同时访问,会覆盖我们当前的Session,所以可以使用Redis解决这个问题
        Users userLogin = (Users) session.getAttribute("userLogin");
        System.out.println(userLogin);
        if (userLogin == null){
            //用户没有登录成功或者Session过期了(session默认是30分钟过期)
            //用户未登录,设置响应类型
            response.setContentType("text/html;charset=UTF-8");
            //方式1:直接重定向到登录页面
            response.sendRedirect("/login.html");
            //拦截,跳转一个提示页面
            return false;
        }else {
            //放行
            return true;
        }
    }
}
