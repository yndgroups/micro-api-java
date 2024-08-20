package ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.configuration;

import ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.utils.RedisUserUtil;
import ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.utils.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description token过滤器
 *
 * @author yangdaqiong
 * @date 2019-07-30 15:51
 **/
@Component
public class AuthFilter implements HandlerInterceptor {

    @Autowired
    private RedisUserUtil redisUserUtil;

    /**
     * description token验证器
     *
     * @param
     * @return
     * @auther: yangdaqiong
     * @date 2019-06-26 14:03
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws CustomException {
        String tokenStr = request.getHeader("accessToken");
        if (ValidateUtil.isNotEmpty(tokenStr)) {
            Boolean isLogin = redisUserUtil.isLogin(tokenStr);
            if (!isLogin) {
                throw new CustomException(ResponseEnum.TOKEN_NOT_EXIST);
            }
            return true;
        } else {
            throw new CustomException(ResponseEnum.TOKEN_NOT_EXIST);
        }
    }
}