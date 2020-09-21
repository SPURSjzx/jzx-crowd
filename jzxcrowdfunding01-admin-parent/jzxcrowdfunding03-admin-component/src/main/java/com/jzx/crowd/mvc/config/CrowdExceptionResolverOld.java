//package com.jzx.crowd.mvc.config;
//
//import com.google.gson.Gson;
//import com.jzx.crowd.util.CrowdUtil;
//import com.jzx.crowd.util.ResultEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @title: CrowdExceptionResolver
// * ControllerAdvice : 用来处理controller的异常
// * @Author Jzxxxx
// * @Date: 2020/9/17 21:54
// * @Version 1.0
// */
////@ControllerAdvice 表示当前类是一个基于注解的异常处理类
//@ControllerAdvice
//public class CrowdExceptionResolverOld {
//    @ExceptionHandler(value = ArithmeticException.class)
//    public ModelAndView resolveMethException(
//            ArithmeticException exception,
//            HttpServletRequest request,
//            HttpServletResponse response
//        ) throws IOException {
//        //1 判断当前请求是什么类型
//        boolean judgeRequest = CrowdUtil.judgeRequestType(request);
//        //2 如果是Ajax请求 judgeRequest会返回true
//        if(judgeRequest){
//            //3 创建一个ResultEntity对象
//            ResultEntity<Object> resultEntity = ResultEntity.failed(exception.getMessage());
//            //4 创建Gson对象将ResultEntity对象转为Json
//            Gson gson = new Gson();
//            //5 将ResultEntity对象转为json字符串
//            String json = gson.toJson(resultEntity);
//            //6 将json字符串作为响应体返回给浏览器
//            response.getWriter().write(json);
//            //7 由于已经返回了响应，不需要提供modelandview对象
//            return  null;
//        }
//        //8 如果不是ajax请求 则创建modelandview对象
//        ModelAndView modelAndView = new ModelAndView();
//        //9 将Exception对象存入模型
//        modelAndView.addObject("exception", exception);
//        //10 设置对应的视图
//        modelAndView.setViewName("system-error");
//        //11 返回modelAndView
//        return modelAndView;
//    }
//
//    // @ExceptionHandler将一个具体的异常类型和一个方法关联起来
//    @ExceptionHandler(value = NullPointerException.class)
//    public ModelAndView resolveNullPointerException(
//            //实际捕获到的异常类型
//            NullPointerException exception,
//            //当前请求对象
//            HttpServletRequest request,
//            //当前响应对象
//            HttpServletResponse response
//            ) throws IOException {
//
//        //1 判断当前请求是什么类型
//        boolean judgeRequest = CrowdUtil.judgeRequestType(request);
//        //2 如果是Ajax请求 judgeRequest会返回true
//        if(judgeRequest){
//            //3 创建一个ResultEntity对象
//            ResultEntity<Object> resultEntity = ResultEntity.failed(exception.getMessage());
//            //4 创建Gson对象将ResultEntity对象转为Json
//            Gson gson = new Gson();
//            //5 将ResultEntity对象转为json字符串
//            String json = gson.toJson(resultEntity);
//            //6 将json字符串作为响应体返回给浏览器
//            response.getWriter().write(json);
//            //7 由于已经返回了响应，不需要提供modelandview对象
//            return  null;
//        }
//        //8 如果不是ajax请求 则创建modelandview对象
//        ModelAndView modelAndView = new ModelAndView();
//        //9 将Exception对象存入模型
//        modelAndView.addObject("exception", exception);
//        //10 设置对应的视图
//        modelAndView.setViewName("system-error");
//        //11 返回modelAndView
//        return modelAndView;
//    }
//}
