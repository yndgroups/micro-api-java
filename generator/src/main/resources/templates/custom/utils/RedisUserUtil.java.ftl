package ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.utils;

import ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.configuration.Constant;
import ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.configuration.CustomException;
import ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.configuration.ResponseEnum;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * description redis服务
 *
 * @param
 * @author yangdaqiong
 * @return
 * @date 2019/9/20 16:27
 **/
@Component
public class RedisUserUtil {

    @Autowired
    private RedisServiceUtil redisServiceUtil;

    /** token前缀 */
    private final static String TOKEN_PREFIX = "login_";

    /** 最小长度 */
    private final static int MIN_LEN = 2;

    /** tokenKey */
    private final static String TOKEN_KEY = "token";

    /** 空格 */
    private final static String SPACE = " ";

    /**
     * description 获取redis存储的登陆信息
     *
     * @param
     * @return
     * @author yangdaqiong
     * @date 2019/10/6 16:36
     **/
    public String getUser(String token) {
        String tokeUser = JSON.toJSONString(JwtUtil.parseToken(token));
        TokenParseUser tokenParseUser = JSON.toJavaObject(JSON.parseObject(tokeUser), TokenParseUser.class);
        String redisTokenKey = "login_" + tokenParseUser.getUserId();
        String userToken = redisServiceUtil.getString(redisTokenKey);
        /**
         * 有token 更新缓存储时间并返回登录信息
         */
        if (userToken != null) {
            redisServiceUtil.updateTime(redisTokenKey, Constant.redisStoreTime);
            return userToken;
        } else {
            throw new CustomException(ResponseEnum.LOGIN_NOT);
        }
    }

    /**
     * description 验证用户是否登录
     *
     * @param token
     * @return boolean
     * @author yangdaqiong
     * @date 2019/10/6 16:35
     **/
    public boolean isLogin(String token) {
        String target = ".";
        int i = appearNumber(token, target);
        if (i < MIN_LEN) {
            throw new CustomException(ResponseEnum.TOKEN_FORMAT_ERROR);
        }
        Claims claims = JwtUtil.parseToken(token);
        String tokeUser = JSON.toJSONString(claims);
        TokenParseUser tokenParseUser = JSON.toJavaObject(JSON.parseObject(tokeUser), TokenParseUser.class);
        String redisTokenKey = TOKEN_PREFIX + tokenParseUser.getUserId();
        String userToken = redisServiceUtil.getString(redisTokenKey);
        if (userToken != null) {
            // token比较，相当于单点登录控制
            JSONObject userJson = JSONObject.parseObject(userToken);
            if (userJson.getString(TOKEN_KEY).equals(token.split(SPACE)[1])) {
                redisServiceUtil.updateTime(redisTokenKey, Constant.redisStoreTime);
                return true;
            } else {
                throw new CustomException(ResponseEnum.TOKEN_NOT_EXIST);
            }
        } else {
            return false;
        }
    }

    /**
     * description 查询某个字符出现的次数
     *
     * @param
     * @return
     * @author yangdaqiong
     * @date 2020/05/07 17:27
     **/
    public int appearNumber(String srcText, String findText) {
        int count = 0;
        String string = srcText;
        String in = findText;
        char[] ch = string.toCharArray();
        char c = in.charAt(0);
        for (int i = 0; i < ch.length; i++) {
            if (c == ch[i]) {
                count++;
            }
        }
        return count;
    }

    /**
     * description token 转对象
     *
     * @param
     * @return JwtRedisUser
     * @author yangdaqiong
     * @date 2019-07-05 19:29
     */
    public TokenParseUser getUser() {
        String reqToken = HttpContextUtil.getToken();
        // 判断是否为空
        if (StringUtils.isEmpty(reqToken)) {
            throw new CustomException(ResponseEnum.TOKEN_NOT_EXIST);
        }
        // 判断是否登录
        Boolean isLogin = isLogin(reqToken);
        if (isLogin) {
            JSONObject userJson = JSONObject.parseObject(getUser(reqToken));
            if (userJson == null) {
                throw new CustomException(ResponseEnum.TOKEN_PARSE_FAIL);
            }
            TokenParseUser loginUser = JSON.toJavaObject(userJson, TokenParseUser.class);
            return loginUser;
        } else {
            throw new CustomException(ResponseEnum.LOGIN_NOT);
        }
    }

    /**
     * description token 微信授权转对象拿出对应的key去取redis缓存
     *
     * @param
     * @return
     * @author yangdaqiong
     * @date 2019/11/22 15:54
     **/
    public TokenParseWeChatUser getWxUser() {
        String reqToken = HttpContextUtil.getToken();
        // 判断是否为空
        if (StringUtils.isEmpty(reqToken)) {
            throw new CustomException(ResponseEnum.TOKEN_NOT_EXIST);
        }
        // 判断是否登录
        Boolean isLogin = isLogin(reqToken);
        if (isLogin) {
            JSONObject userJson = JSONObject.parseObject(getRedisUser(reqToken));
            if (userJson == null) {
                throw new CustomException(ResponseEnum.TOKEN_PARSE_FAIL);
            }
            TokenParseWeChatUser loginUser = JSON.toJavaObject(userJson, TokenParseWeChatUser.class);
            return loginUser;
        } else {
            throw new CustomException(ResponseEnum.LOGIN_NOT);
        }
    }

    /**
     * description 获取redis存储的登陆信息
     *
     * @param
     * @return String
     * @author yangdaqiong
     * @date 2019/10/6 16:36
     **/
    public String getRedisUser(String token) {
        String tokeUser = JSON.toJSONString(JwtUtil.parseToken(token));
        TokenParseUser tokenParseUser = JSON.toJavaObject(JSON.parseObject(tokeUser), TokenParseUser.class);
        String redisTokenKey = TOKEN_PREFIX + tokenParseUser.getUserId();
        String userToken = redisServiceUtil.getString(redisTokenKey);
        /** 有token 更新缓存储时间并返回登录信息 */
        if (userToken != null) {
            redisServiceUtil.updateTime(redisTokenKey, Constant.redisStoreTime);
            return userToken;
        } else {
            throw new CustomException(ResponseEnum.LOGIN_NOT);
        }
    }

    /**
     * description 判断是否有 token
     *
     * @param
     * @return
     * @author yangdaqiong
     * @date 2019-07-02 16:00
     */
    public void getUserIsNull() {
        String token = HttpContextUtil.getHandlerIsNull();
        if (StringUtils.isEmpty(token)) {
            throw new CustomException(ResponseEnum.LOGIN_NOT);
        }
    }
}