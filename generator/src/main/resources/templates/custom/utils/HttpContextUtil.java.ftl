package ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.utils;

import ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.configuration.CustomException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * description 上下文工具类
 * @author: yangdaqiong
 * @date 2019-07-22 0:31
 */
public class HttpContextUtil {
    /**
     * description SpringMvc下获取request
     * @param
     * @return
     * @auther: yangdaqiong
     * @date 2019-07-22 0:30
     */
    public static HttpServletResponse getResponse() {
        HttpServletResponse response = ((ServletWebRequest) RequestContextHolder.getRequestAttributes()).getResponse();
        return response;
    }

    /**
     * description SpringMvc下获取res
     * @param
     * @return
     * @auther: yangdaqiong
     * @date 2019-07-22 0:30
     */
    public static HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;

    }

    /**
     * description SpringMvc下获取session
     * @param
     * @return
     * @auther: yangdaqiong
     * @date 2019-07-22 0:30
     */
    public static HttpSession getSession() {
        HttpSession session = getRequest().getSession();
        return session;

    }

    /**
     * description 获取头部信息Handler中的token值
     * @param
     * @return
     * @auther: yangdaqiong
     * @date 2019-07-22 0:30
     */
    public static String getToken() {
        String token = null;
        try {
            Object handler = getRequest().getHeaders("accessToken");
            token = ((Enumeration) handler).nextElement().toString();
        } catch (Exception e) {
            System.out.println("==========未获取到token信息==========" + e.getMessage());
            throw new CustomException(0, "未获取到token信息");
        }
        return token;
    }

    /**
     * description 检测token是否为空
     * @param
     * @return
     * @auther: yangdaqiong
     * @date 2019-07-22 0:29
     */
    public static String getHandlerIsNull() {
        String token = null;
        try {
            Object handler = getRequest().getHeaders("accessToken");
            token = ((Enumeration) handler).nextElement().toString();
        } catch (Exception e) {
            System.out.println("==========未获取到token信息==========" + e.getMessage());
        }
        return token;
    }
}