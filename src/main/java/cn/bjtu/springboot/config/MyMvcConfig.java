package cn.bjtu.springboot.config;

import cn.bjtu.springboot.component.LoginHandlerInteceptor;
import cn.bjtu.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.Locale;

/**
 * @author chancey
 * @create 2020-04-25 13:16
 */
//使用WebMvcConfigurer[WebMvcConfigurerAdapter已过时]可以来扩展SpringMVC的功能
//@EnableWebMvc 不要用
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送 /atguigu 请求来到 success
        registry.addViewController("/atguigu").setViewName("success");
    }

//    @Override 这样也可以访问首页
//    public void addViewControllers(ViewControllerRegistry registry) {
//        //浏览器发送 /atguigu 请求来到 success
//        registry.addViewController("/").setViewName("login");
//    }

    //自定义一个webMvcConfigurer，所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean //前提：将组件注册在容器
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            //配置一个视图控制器
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册一个拦截器

//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                //静态资源；  *.css , *.js
//                ///**任意路径下的任意请求都拦截，除了...
//                //SpringBoot已经做好了静态资源映射,我们可以正常访问，不需要手动配置
//                registry.addInterceptor(new LoginHandlerInteceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/","/index.html","/user/login");
//            }
        };
        return webMvcConfigurer;
    }

    //向容器中添加自己创建的区域信息解析器组件
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

}
