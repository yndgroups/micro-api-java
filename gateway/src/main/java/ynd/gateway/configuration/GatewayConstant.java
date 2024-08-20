package ynd.gateway.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * description gateway静态配置
 *
 *@author yangdaqiong
 *@date 2021-04-29 23:04:46
 **/
@RefreshScope
@Configuration
public class GatewayConstant {

    /* jwt 公钥 */
    public static String jwtPublicSecret;

    /* jwt 私钥 */
    public static String jwtPrivateSecret;

    /* 请求头参数 */
    public static String reqHeader;

    /* token前缀 */
    public static String tokenPrefix;

    /* 登录存储前缀 */
    public static String loginPrefix;

    /* 一般用户登录时间设定（2小时）*/
    public static Long publicLoginTime;

    /* 微信登录信息存储时间（一个周） */
    public static Long wxLoginTime;

    /* 不做redis token 校验的接口 */
    public static String noAuthPath;

    @Value("${application.jwt.jwtPublicSecret}")
    public void setJwtPublicSecret(String jwtPublicSecret) {
        GatewayConstant.jwtPublicSecret = jwtPublicSecret;
    }

    @Value("${application.jwt.jwtPrivateSecret}")
    public void setJwtPrivateSecret(String jwtPrivateSecret) {
        GatewayConstant.jwtPrivateSecret = jwtPrivateSecret;
    }


    @Value("${application.jwt.tokenPrefix:'Bearer '}")
    public void setTokenPrefix(String tokenPrefix) {
        GatewayConstant.tokenPrefix = tokenPrefix;
    }

    @Value("${application.jwt.reqHeader:accessToken}")
    public void setReqHeader(String reqHeader) {
        GatewayConstant.reqHeader = reqHeader;
    }

    @Value("${application.jwt.loginPrefix:login_}")
    public void setLoginPrefix(String loginPrefix) {
        GatewayConstant.loginPrefix = loginPrefix;
    }

    @Value("${application.jwt.noAuthPath}")
    public void setNoAuthPath(String noAuthPath) {
        GatewayConstant.noAuthPath = noAuthPath;
    }

    @Value("${application.jwt.publicLoginTime:7200}")
    public void setPublicLoginTime(Long publicLoginTime) {
        GatewayConstant.publicLoginTime = publicLoginTime;
    }

    @Value("${application.jwt.wxLoginTime:172800}")
    public void setWxLoginTime(Long wxLoginTime) {
        GatewayConstant.wxLoginTime = wxLoginTime;
    }
}
