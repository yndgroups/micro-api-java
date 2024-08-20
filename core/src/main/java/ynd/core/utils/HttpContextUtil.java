package ynd.core.utils;

import ynd.core.constant.BaseConstant;
import ynd.core.exception.CustomException;
import ynd.core.logs.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * description 上下文工具类
 *
 * @author yangdaqiong
 * @date 2019-07-22 0:31
 */
public class HttpContextUtil {

    /**
     * description SpringMvc下获取response
     *
     * @return HttpServletResponse
     * @author yangdaqiong
     * @date 2019-07-22 0:30
     */
    public static HttpServletResponse getResponse() {
        HttpServletResponse response = ((ServletWebRequest) RequestContextHolder.getRequestAttributes()).getResponse();
        return response;
    }

    /**
     * description SpringMvc下获取request
     *
     * @return HttpServletRequest
     * @author yangdaqiong
     * @date 2019-07-22 0:30
     */
    public static HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;

    }

    /**
     * description SpringMvc下获取session
     *
     * @return HttpSession
     * @author yangdaqiong
     * @date 2019-07-22 0:30
     */
    public static HttpSession getSession() {
        HttpSession session = getRequest().getSession();
        return session;

    }

    /**
     * description 获取头部信息Handler中的token值
     *
     * @return String
     * @author yangdaqiong
     * @date 2019-07-22 0:30
     */
    public static String getToken() {
        String token;
        try {
            Object handler = getRequest().getHeaders(BaseConstant.reqHeader);
            token = ((Enumeration) handler).nextElement().toString();
        } catch (Exception e) {
            Logger.e("getToken >>> 未获取到token信息 >>>", e.getMessage());
            throw new CustomException(0, "未获取到token信息");
        }
        return token;
    }

    /**
     * description 获取请求头里的appId
     *
     * @return java.lang.String
     * @author yangdaqiong
     * @date 2021-06-05 22:20:04
     **/
    public static String getAppId() {
        String appId;
        try {
            Object handler = getRequest().getHeaders("appId");
            appId = ((Enumeration) handler).nextElement().toString();
        } catch (Exception e) {
            Logger.e("getToken >>> 未获取到appId信息 >>>", e.getMessage());
            throw new CustomException(0, "未获取到token信息");
        }
        return appId;
    }

    /**
     * description 检测token是否为空
     *
     * @return String
     * @author yangdaqiong
     * @date 2019-07-22 0:29
     */
    public static String getHandlerIsNull() {
        String token;
        try {
            Object handler = getRequest().getHeaders(BaseConstant.reqHeader);
            token = ((Enumeration) handler).nextElement().toString();
        } catch (Exception e) {
            Logger.e("getHandlerIsNull >>> 未获取到token信息 >>>", e.getMessage());
            throw new CustomException(0, "未获取到token信息");
        }
        return token;
    }
}
