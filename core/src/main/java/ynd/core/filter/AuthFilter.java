package ynd.core.filter;

import ynd.core.constant.BaseConstant;
import ynd.core.exception.CustomException;
import ynd.core.service.RedisUserService;
import ynd.core.utils.ValidateUtil;
import ynd.core.emums.ResponseEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yangdaqiong
 * @description HandlerInterceptor 拦截器
 * @date 2019-06-26 12:51
 **/
@Component
public class AuthFilter implements HandlerInterceptor {

    @Autowired
    private RedisUserService redisUserService;


    /**
     * description 验证token 拦截
     *
     * @param request  经过spring封装的请求对象, 包含请求地址, 头, 参数, body(流)等信息.
     * @param response 经过spring封装的响应对象, 包含输入流, 响应body类型等信息.
     * @param handler  是指controller的@Controller注解下的"完整"方法名, 是包含exception等字段信息的.
     * @author yangdaqiong
     * @date 2019-06-26 14:03
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String sourceId = request.getHeader("source-id");
        if (BaseConstant.currentAuth) {
            String tokenStr = request.getHeader(BaseConstant.reqHeader);
            String requestURI = request.getRequestURI();
            Boolean isNoAuth = false;
            String noAuthPath = BaseConstant.noAuthPath;
            if (StringUtils.isNotEmpty(noAuthPath)) {
                String[] split = noAuthPath.split(",");
                if (split.length > 0) {
                    for (String s : split) {
                        if (requestURI.indexOf(s) >= 0) {
                            isNoAuth = true;
                            break;
                        }
                    }
                }
            }
            if (isNoAuth) {
                return true;
            } else if (ValidateUtil.isNotEmpty(tokenStr)) {
                if (tokenStr.length() < 20) {
                    throw new CustomException(ResponseEnum.TOKEN_PARSE_ERROR);
                }
                if (!tokenStr.startsWith(BaseConstant.tokenPrefix)) {
                    throw new CustomException(ResponseEnum.TOKEN_FORMAT_ERROR);
                }
                Boolean isLogin = redisUserService.isLogin();
                if (!isLogin) {
                    throw new CustomException(ResponseEnum.TOKEN_NOT_EXIST);
                }
                return true;
            } else {
                throw new CustomException(ResponseEnum.TOKEN_NOT_EXIST);
            }
        } else {
            if (BaseConstant.jwtPublicSecret.equals(sourceId)) {
                return true;
            } else {
                throw new CustomException(ResponseEnum.BAD_REQUEST);
            }
        }

    }

}
