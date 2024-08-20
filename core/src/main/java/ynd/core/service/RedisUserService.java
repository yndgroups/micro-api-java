package ynd.core.service;

import ynd.core.constant.BaseConstant;
import ynd.core.emums.ResponseEnum;
import ynd.core.exception.CustomException;
import ynd.core.jwt.JwtManage;
import ynd.core.model.PayConf;
import ynd.core.model.TokenParseUser;
import ynd.core.model.TokenParseUserAuth;
import ynd.core.utils.HttpContextUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * description redis服务
 *
 * @author yangdaqiong
 * @date 2019-09-20 16:27
 **/
@Component
public class RedisUserService {

    @Autowired
    private RedisService redisService;

    /**
     * description 获取redis存储的登陆信息
     *
     * @author yangdaqiong
     * @date 2019-10-6 16:36
     **/
    public TokenParseUserAuth getAuthUser() {
        // 每个系统都有自己的唯一标识appId
        String appId = BaseConstant.appId;
        String redisKey = getRedisKeyByToken(BaseConstant.loginPrefix);
        String userInfo = redisService.getString(redisKey);
        /**
         * 有token 更新缓存储时间并返回登录信息
         */
        if (userInfo != null) {
            redisService.updateTime(redisKey, BaseConstant.publicLoginTime);
            TokenParseUser loginUser = JSON.toJavaObject(JSONObject.parseObject(userInfo), TokenParseUser.class);
            TokenParseUserAuth tokenParseUserAuth = new TokenParseUserAuth(loginUser.getUserId(), loginUser.getUserName(), loginUser.getAreaCode(), loginUser.getAreaTag(), loginUser.getAreaName(), loginUser.getToken(), loginUser.getAppId(), loginUser.getOpenId(), loginUser.getAccountType(), null, loginUser.getWxAccessToken());
            return tokenParseUserAuth;
        } else {
            throw new CustomException(ResponseEnum.LOGIN_NOT);
        }
    }

    /**
     * description 获取用户的权限值
     *
     * @param
     * @return java.lang.String[]
     * @author yangdaqiong
     * @date 2021-06-16 23:21:35
     **/
    public String getPowerSign() {
        String redisKey = getRedisKeyByToken("power_");
        String powerSign = redisService.getString(redisKey);
        if (powerSign != null && !"".equals(powerSign)) {
            return powerSign;
        } else {
            throw new CustomException(0, "未查询到您的授权信息");
        }
    }

    /**
     * description 验证用户是否登录
     *
     * @return boolean
     * @author yangdaqiong   admin:org:add
     * * @author yangdaqiong   admin:org:list
     * * @author yangdaqiong   admin:org:delete
     * @date 2019-10-06 16:35
     **/
    public boolean isLogin() throws Exception {
        TokenParseUserAuth authUser = getAuthUser();
        if (authUser != null && authUser.getUserId() != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * description  根据token解析出userId
     *
     * @param prefix 前缀 token解析的用户信息
     * @return 组装好的token存储的key
     */
    public String getRedisKeyByToken(String prefix) {
        Claims claims = JwtManage.parseToken(HttpContextUtil.getToken());
        TokenParseUser tokenParseUser = JSON.toJavaObject(JSON.parseObject(JSON.toJSONString(claims)), TokenParseUser.class);
        return prefix + tokenParseUser.getUserId();
    }

    /**
     * description token 微信授权转对象拿出对应的key去取redis缓存
     *
     * @return TokenParseWeChatUserVo
     * @author yangdaqiong
     * @date 2019-11-22 15:54
     **/
    /*public TokenParseWeChatUser getWxUser() throws Exception {
        String reqWxToken = HttpContextUtil.getToken();
        // 判断是否为空
        if (StringUtils.isEmpty(reqWxToken)) {
            throw new CustomException(ResponseEnum.TOKEN_NOT_EXIST);
        }
        // 判断是否登录
        Boolean isLogin = isLogin(reqWxToken);
        if (isLogin) {
            JSONObject userJson = JSONObject.parseObject(getRedisUser(reqWxToken));
            if (userJson == null) {
                throw new CustomException(ResponseEnum.TOKEN_PARSE_FAIL);
            }
            TokenParseWeChatUser loginUser = JSON.toJavaObject(userJson, TokenParseWeChatUser.class);
            return loginUser;
        } else {
            throw new CustomException(ResponseEnum.LOGIN_NOT);
        }
    }*/

    /**
     * description 判断是否有 token
     *
     * @return void
     * @author yangdaqiong
     * @date 2019-07-02 16:00
     */
    public void getUserIsNull() {
        String token = HttpContextUtil.getHandlerIsNull();
        if (StringUtils.isEmpty(token)) {
            throw new CustomException(ResponseEnum.LOGIN_NOT);
        }
    }

    /**
     * description 统一获取配置文件
     *
     * @param confId 配置id
     * @return BackResult 返回查询结果
     * @author yangdaqiong
     * @date 2021-08-29 14:50:06
     **/
    public PayConf getPayConf(String confId) {
        String confKey = "conf_" + confId;
        String configString = redisService.getString(confKey);
        if (configString != null) {
            return JSON.toJavaObject(JSON.parseObject(configString), PayConf.class);
        } else {
            return null;
        }
    }

    /**
     * description 创建唯一一主键id
     *
     * @return Long 主键id
     * @author yangdaqiong
     * @date 2021-09-25 11:34:09
     **/
    public Long createPrimaryKey(String key) {
        return redisService.createKey(key);
    }

    /**
     * description 创建唯一一主键id
     *
     * @return Long 主键id
     * @author yangdaqiong
     * @date 2021-09-25 11:34:09
     **/
    public Long createPrimaryKey() {
        return redisService.createKey("COMMON_KEY_ID");
    }
}
