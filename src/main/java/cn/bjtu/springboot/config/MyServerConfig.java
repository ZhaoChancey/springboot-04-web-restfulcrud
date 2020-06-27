package cn.bjtu.springboot.config;

import cn.bjtu.springboot.filter.Filter;
import cn.bjtu.springboot.listener.Listener;
import cn.bjtu.springboot.servlet.MyServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import java.util.Arrays;

/**
 * 原来的废弃了EmbeddedServletContainerCustomizer
 *
 * @author chancey
 * @create 2020-04-27 22:53
 */
@Configuration
public class MyServerConfig {


    //注册三大组件
    @Bean
    public ServletRegistrationBean registrationBean() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new Filter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener() {
        ServletListenerRegistrationBean<Listener> registrationBean = new ServletListenerRegistrationBean<>(new Listener());
        return registrationBean;
    }

    @Bean
    //配置嵌入式的Servlet容器
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8083);
            }
        };
    }
}
