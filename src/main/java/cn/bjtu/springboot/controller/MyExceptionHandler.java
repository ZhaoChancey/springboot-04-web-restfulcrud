package cn.bjtu.springboot.controller;

import cn.bjtu.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义客户端访问的错误页面定制信息
 *
 * @author chancey
 * @create 2020-04-27 20:46
 */
//表明这是一个异常处理器
@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 第一种自定义的异常处理机制
     *
     * @param e ：只要出现这个异常，SpringMVC就会调用这个方法异常的对象传进来
     * @return
     * @ExceptionHandler表示要处理什么异常
     */
    //1、浏览器客户端返回的都是json数据，没有自适应效果
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String,Object> handleException(Exception e){
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","user.notExist");
//        map.put("message",e.getMessage());
//        return map;
//    }
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        //一定要通过设置javax.servlet.error.status_code传入我们自己的错误状态码  4xx 5xx,不传默认是200
        /**
         * Integer statusCode = (Integer) request
         .getAttribute("javax.servlet.error.status_code");
         */
        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("code", "user.notExist");
        map.put("message", e.getMessage());

        request.setAttribute("etc", map);
        //转发到/error,让BasicErrorController帮我们自适应处理
        return "forward:/error";
    }
}
