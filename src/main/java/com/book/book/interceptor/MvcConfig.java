//package com.book.book.interceptor;//
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//@Configuration
//public class MvcConfig implements WebMvcConfigurer {
//
//    // dx 拦截器功能
//    @Override
//    public void addInterceptors(InterceptorRegistry registry){
//        registry.addInterceptor(new LoginInterceptor())
//                .excludePathPatterns(
//                        "/login.html",
//                        "/register.html",
//                        "/codeImage",
//                        "/tAdmin/login",
//                        "/tAdmin/register",
//                        "/tAdmin/sendCode",
//                        "/tAdmin/checkUserName",
//                        "/js/*",
//                        "/javaex/**"
//                ).order(1);
//    }
//}
