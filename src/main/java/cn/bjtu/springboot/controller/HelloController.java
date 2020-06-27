package cn.bjtu.springboot.controller;

import cn.bjtu.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @author chancey
 * @create 2020-04-24 21:51
 */
@Controller
public class HelloController {

//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "login";
//    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user) {
        if (user.equals("aaa")) {
            throw new UserNotExistException();
        }
        return "Hello World";

    }

    //查出用户数据，在页面展示
    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        //classpath:/templates/success.html
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("xiao1", "xiao2", "xiao3"));
        return "success";
    }
}
