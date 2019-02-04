package com.Sugarda.gatewayService.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Configuration//该注解是让服务器启动时将奔雷作为配置类注入到spring容器。如若不加此注解，需在启动类配置该bean
public class AccessFilter extends ZuulFilter {

    //从配置文件读取access token在回传json中的名字
    @Value("${AccessToken.ParameterName}")
    private String accessTokenParameterName;

    //配置日志类
    private static final Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    //可以在请求被路由之前调用
    @Override
    public String filterType() {
        return "pre";
    }

    //通过int值来定义过滤器的执行顺序，越小的值越优先处理。
    @Override
    public int filterOrder() {
        return 0;
    }

    //返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关。true:总是生效，false:不生效
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 配置网关服务验证返回的数据中是否包含token
     *
     * @return null
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        String accessToken = String.valueOf(httpServletRequest.getHeader(accessTokenParameterName));//从请求头获取accessToken
        //使用map的key-value特性替代多重循环
//        Map<String,Integer> map = new HashMap<String,Integer>(){
//            private static final long serialVersionUID = 1L;
//            {
//                put(null,401);
//                put(accessToken,200);
//            }
//        };
//        boolean flag = map.get(accessToken) == 200 ? true : false;
//        requestContext.setSendZuulResponse(flag);
//        requestContext.setResponseStatusCode(map.get(accessToken));//使用map替代多重循环,此时记录日志会显得很蠢==就没用
        //判断用户携带的信息是否包含accessToken
        if (accessToken == "null") {//springboot中为了保证正确，会自动将null转为字符串？？？什么玩意吗？？？
            logger.warn("login fail : accessToken is " + accessToken);
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            return null;
        } else {
            logger.info("login success : accessToken is " + accessToken);
            return null;
        }
    }
}
