package cn.bjtu.springboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 给容器中加入我们自己定义的ErrorAttributes
 *
 * @author chancey
 * @create 2020-04-27 22:12
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company", "cn.bjtu");
        Map<String, Object> etc = (Map<String, Object>) webRequest.getAttribute("etc", 0);
        map.put("etc", etc);
        return map;
    }
}
