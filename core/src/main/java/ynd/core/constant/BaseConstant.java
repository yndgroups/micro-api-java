package ynd.core.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * description 基础变量
 *
 * @author yangdaqiong
 * @date 2019-08-30 15:27
 **/
@RefreshScope
@Configuration
public class BaseConstant {

    public static String version;
    public static String appId;
    public static Integer deleteType;
    public static String jwtPublicSecret;
    public static String jwtPrivateSecret;
    public static String noAuthPath;
    public static Boolean currentAuth;
    public static Long wxLoginTime;
    public static Long publicLoginTime;
    public static String reqHeader;
    public static String tokenPrefix;
    public static String loginPrefix;
    public static Boolean swaggerEnable;
    public static Long administrator;

    /**
     * 运维标识
     */
    @Value("${application.administrator:666888}")
    public void setAdministrator(Long administrator) {
        BaseConstant.administrator = administrator;
    }

    /**
     * 1是逻辑删除 2物理删除
     */
    @Value("${application.version:1.0}")
    public void setVersion(String version) {
        BaseConstant.version = version;
    }

    /**
     * 1是逻辑删除 2物理删除
     */
    @Value("${application.appId}")
    public void setAppId(String appId) {
        BaseConstant.appId = appId;
    }

    /**
     * 1是逻辑删除 2物理删除
     */
    @Value("${application.deleteType:1}")
    public void setDeleteType(Integer deleteType) {
        BaseConstant.deleteType = deleteType;
    }

    /**
     * 公钥
     */
    @Value("${application.jwt.jwtPublicSecret}")
    public void setJwtPublicSecret(String jwtPublicSecret) {
        BaseConstant.jwtPublicSecret = jwtPublicSecret;
    }

    /**
     * 私钥
     */
    @Value("${application.jwt.jwtPrivateSecret}")
    public void setJwtPrivateSecret(String jwtPrivateSecret) {
        BaseConstant.jwtPrivateSecret = jwtPrivateSecret;
    }

    /**
     * 不做验证接口
     */
    @Value("${application.jwt.noAuthPath}")
    public void setNoAuthPath(String noAuthPath) {
        BaseConstant.noAuthPath = noAuthPath;
    }

    /**
     * 不做验证接口
     */
    @Value("${application.jwt.currentAuth:true}")
    public void setCurrentAuth(Boolean currentAuth) {
        BaseConstant.currentAuth = currentAuth;
    }

    /**
     * 微信登录时间
     */
    @Value("${application.jwt.wxLoginTime:172800}")
    public void setWxLoginTime(Long wxLoginTime) {
        BaseConstant.wxLoginTime = wxLoginTime;
    }

    /**
     * 微信登录时间
     */
    @Value("${application.jwt.publicLoginTime:7200}")
    public void setPublicLoginTime(Long publicLoginTime) {
        BaseConstant.publicLoginTime = publicLoginTime;
    }

    /**
     * token名称
     */
    @Value("${application.jwt.reqHeader:accessToken}")
    public void setReqHeader(String reqHeader) {
        BaseConstant.reqHeader = reqHeader;
    }

    /**
     * token前缀
     */
    @Value("${application.jwt.tokenPrefix:'Bearer '}")
    public void setTokenPrefix(String tokenPrefix) {
        BaseConstant.tokenPrefix = tokenPrefix;
    }

    /**
     * 登陆存储前缀
     */
    @Value("${application.jwt.loginPrefix:login_}")
    public void setLoginPrefix(String loginPrefix) {
        BaseConstant.loginPrefix = loginPrefix;
    }

    /**
     * 是否开启文档
     */
    @Value("${application.swagger.enable:false}")
    public void setSwaggerEnable(Boolean swaggerEnable) {
        BaseConstant.swaggerEnable = swaggerEnable;
    }

}
