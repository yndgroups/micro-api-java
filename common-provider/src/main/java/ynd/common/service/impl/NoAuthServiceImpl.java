package ynd.common.service.impl;


import ynd.common.pojo.vo.JsSdkVo;
import ynd.common.pojo.vo.LoginBackVo;
import ynd.common.pojo.vo.WeChatUserInsertVo;
import ynd.common.pojo.vo.WeChatWebLoginVo;
import ynd.common.service.UserService;
import ynd.common.service.NoAuthService;
import ynd.common.service.PayConfService;
import ynd.common.service.PowerService;
import ynd.common.service.feign.FeignTeachingService;
import ynd.core.constant.BaseConstant;
import ynd.core.emums.ResponseEnum;
import ynd.core.exception.CustomException;
import ynd.core.jwt.JwtManage;
import ynd.core.model.WechatLoginBack;
import ynd.core.model.PayConf;
import ynd.core.result.BackResult;
import ynd.core.service.RedisService;
import ynd.core.service.RedisUserService;
import ynd.core.utils.HttpRequestUtil;
import ynd.core.utils.ValidateUtil;
import ynd.core.utils.WeChatUtil;
import ynd.common.entity.UserEntity;
import ynd.common.entity.PayConfEntity;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NoAuthServiceImpl implements NoAuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private RedisUserService redisUserService;

    @Autowired
    private PowerService powerService;

    @Autowired
    private PayConfService payConfService;

    @Autowired
    public FeignTeachingService feignTeachingService;

    @Override
    public BackResult login(LoginBackVo loginBackVo) {
        switch (loginBackVo.getLoginType()) {
            case 1: // 用户名密码登录
                ValidateUtil.validateFiled(loginBackVo.getUserName(), "用户名不能为空");
                ValidateUtil.validateFiled(loginBackVo.getUserPassword(), "密码不能为空");
                return userNameOrEmailOrPhoneLogin(loginBackVo);
            case 2: // 邮箱和密码登录
                ValidateUtil.validateFiled(loginBackVo.getEmail(), "登录邮箱不能为空");
                ValidateUtil.validateFiled(loginBackVo.getUserPassword(), "密码不能为空");
                return userNameOrEmailOrPhoneLogin(loginBackVo);
            case 3: // 电话号码验证码登录
                ValidateUtil.validateFiled(loginBackVo.getPhone(), "电话号码不能为空");
                ValidateUtil.validateFiled(loginBackVo.getUserPassword(), "密码不能为空");
                return userNameOrEmailOrPhoneLogin(loginBackVo);
            default:
                throw new CustomException(0, "传入的登录方式取值不正确");
        }
    }

    /**
     * description 用户名或密码登录情况处理
     *
     * @param loginBackVo
     * @return loginBackVo
     * @author BackResult<Data> 返回登陆信息
     * @date 2021-05-16 23:25:00
     */
    private BackResult userNameOrEmailOrPhoneLogin(LoginBackVo loginBackVo) {
        QueryWrapper<UserEntity> eq = new QueryWrapper<UserEntity>();
        switch (loginBackVo.getLoginType()) {
            case 1: // 用户名和密码登录
                eq.lambda().eq(UserEntity::getUserName, loginBackVo.getUserName());
                break;
            case 2: // 邮箱和密和码登录
                eq.lambda().eq(UserEntity::getEmail, loginBackVo.getEmail());
                break;
            case 3://电话号码和密码
                eq.lambda().eq(UserEntity::getPhone, loginBackVo.getPhone());
                break;
        }
        UserEntity userEntity = userService.getBaseMapper().selectOne(eq);
        // 判断用户是否存在
        if (userEntity == null || userEntity.getUserName() == null || "".equals(userEntity.getUserName())) {
            throw new CustomException(ResponseEnum.USER_NOT_EXIST);
        } else {
            // 判断密码是否正确
            String userPassword = DigestUtils.sha512Hex(loginBackVo.getUserPassword());
            if (userPassword.equals(userEntity.getUserPassword())) {
                // 密码正确
                if (userEntity.getDelStatus() == true) {
                    throw new CustomException(0, "您的账号已被删除,请联系管理员恢复或重新注册其他账号！");
                }
                if (userEntity.getStatus() == 2) {
                    throw new CustomException(0, "您的账号已被冻结,请联系管理员恢复");
                } else if (userEntity.getStatus() == 3) {
                    throw new CustomException(0, "您的账号还在审核当中");
                }

                Map<String, Object> redisUser = new HashMap<>(9);
                HashMap<String, Object> userMap = new HashMap<>(2);
                Long loginUserId = userEntity.getUserId();
                String loginUserName = userEntity.getUserName();
                userMap.put("userId", loginUserId);
                String token = JwtManage.createToken(userMap);
                redisUser.put("userId", loginUserId);
                redisUser.put("userName", loginUserName);
                redisUser.put("token", token);
                redisService.setString(BaseConstant.loginPrefix + userEntity.getUserId(), JSON.toJSONString(redisUser), BaseConstant.publicLoginTime);
                HashMap<String, Object> resMap = new HashMap<>(2);
                resMap.put("token", token);
                resMap.put("userName", loginUserName);
                return new BackResult(resMap, ResponseEnum.LOGIN_SUCCESS);
            } else {
                // 密码不正确
                throw new CustomException(ResponseEnum.PASSWORD_ERROR);
            }
        }
    }

    /**
     * description 微信登录
     *
     * @param weChatUserInsertVo 微信登录参数
     * @return ynd.core.result.BackResult
     * @author yangdaqiong
     * @date 2021-06-19 09:17:25
     **/
    @Override
    public BackResult wechatLogin(WeChatUserInsertVo weChatUserInsertVo) throws Exception {
        PayConf payConf = redisUserService.getPayConf(weChatUserInsertVo.getConfId());
        if (payConf == null) {
            LambdaQueryWrapper<PayConfEntity> lambda = new QueryWrapper<PayConfEntity>().lambda();
            lambda.eq(PayConfEntity::getConfId, weChatUserInsertVo.getConfId()).eq(PayConfEntity::getDelStatus, 1);
            PayConfEntity payConfEntity = payConfService.getBaseMapper().selectOne(lambda);
            if (payConfEntity != null) {
                payConf = new PayConf();
                BeanUtils.copyProperties(payConfEntity, payConf);
                redisService.setString("conf_" + payConfEntity.getConfId(), JSON.toJSONString(payConf), BaseConstant.wxLoginTime);
            } else {
                throw new CustomException(0, "未查询到对应的配置新信息");
            }
        }
        String url = String.format("https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code", payConf.getAppId(), payConf.getAppSecret(), weChatUserInsertVo.getWxCode());
        String resp = HttpRequestUtil.get(url);
        WechatLoginBack wechatLoginBack = JSON.toJavaObject(JSON.parseObject(resp), WechatLoginBack.class);
        if (wechatLoginBack != null && wechatLoginBack.getOpenid() != null) {
            LambdaQueryWrapper<UserEntity> queryWrapper = new QueryWrapper<UserEntity>().lambda().eq(UserEntity::getOpenId, wechatLoginBack.getOpenid());
            UserEntity userEntity = userService.getBaseMapper().selectOne(queryWrapper);
            HashMap<String, Object> userInfo = new HashMap<>(5);
            HashMap<String, Object> tokenMap = new HashMap<>(1);
            if (userEntity == null) {
                userEntity = new UserEntity();
                Long userId = redisUserService.createPrimaryKey();
                userEntity.setUserId(userId);
                userEntity.setCreateBy(userId); // wechatLoginBack.getOpenid()
                userEntity.setOpenId(wechatLoginBack.getOpenid());
                userEntity.setRegType(3);
                int insert = userService.getBaseMapper().insert(userEntity);
                if (insert > 0) {
                    // 根据userId构建token
                    tokenMap.put("userId", userId);
                    String token = JwtManage.createToken(tokenMap);
                    // 组装用户登录信息
                    userInfo.put("token", token);
                    userInfo.put("userId", userId);
                    userInfo.put("openId", userEntity.getOpenId());
                    redisService.setString(BaseConstant.loginPrefix + userId, JSON.toJSONString(userInfo), BaseConstant.wxLoginTime);
                    // 同步到微应用
                    weChatUserInsertVo.setUserId(userId);
                    return asyncUserInfo(weChatUserInsertVo, userInfo);
                } else {
                    throw new CustomException(ResponseEnum.AUTH_FAIL);
                }
            } else {
                Long userId = userEntity.getUserId();
                // 根据userId构建token
                tokenMap.put("userId", userId);
                String token = JwtManage.createToken(tokenMap);
                // 组装用户登录信息
                userInfo.put("token", token);
                userInfo.put("userId", userId);
                userInfo.put("openId", userEntity.getOpenId());
                redisService.setString(BaseConstant.loginPrefix + userId, JSON.toJSONString(userInfo), BaseConstant.wxLoginTime);
                weChatUserInsertVo.setUserId(userEntity.getUserId());
                return asyncUserInfo(weChatUserInsertVo, userInfo);
            }
        } else {
            throw new CustomException(0, "微信授权失败：错误代码 -> " + wechatLoginBack.getErrcode());
        }
    }

    /**
     * description 同步到微应用并返回结果
     *
     * @param weChatUserInsertVo 微信用户信息
     * @param userInfo           用户登录信息，主要是返回给前端
     * @return result
     * @author yangdaqiong
     * @date 2021-11-12 23:53:38
     **/
    private BackResult asyncUserInfo(WeChatUserInsertVo weChatUserInsertVo, HashMap<String, Object> userInfo) throws Exception {
        weChatUserInsertVo.setUserId(weChatUserInsertVo.getUserId());
        try {
            BackResult result = feignTeachingService.userInformationSynchronization(weChatUserInsertVo);
            boolean b = (boolean)result.getData();
            if (b) {
                return BackResult.success(userInfo);
            } else {
                throw new CustomException(0, "调用微服务同步用户信息失败");
            }
        } catch (CustomException customException) {
            throw new CustomException(0, "调用微服务同步用户信息失败");
        }
    }

    /**
     * description 微信公众号登录
     *
     * @param weChatWebLoginVo 微信公众号登录参数
     * @return BackResult 登录结果
     * @author yangdaqiong
     * @date 2021-08-08 17:29:52
     **/
    @Override
    public BackResult wechatWebLogin(WeChatWebLoginVo weChatWebLoginVo) {
        PayConf payConf = redisUserService.getPayConf(weChatWebLoginVo.getConfId());
        if (payConf == null) {
            PayConfEntity payConfEntity = payConfService.getBaseMapper().selectById(weChatWebLoginVo.getConfId());
            if (payConfEntity != null) {
                payConf = new PayConf();
                BeanUtils.copyProperties(payConfEntity, payConf);
                redisService.setString("conf_" + payConfEntity.getConfId(), JSON.toJSONString(payConf), BaseConstant.wxLoginTime);
            } else {
                throw new CustomException(0, "未查询到对应的配置新信息");
            }
        }
        String url = String.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code", payConf.getAppId(), payConf.getAppSecret(), weChatWebLoginVo.getWxCode());
        String resp = HttpRequestUtil.get(url);
        WechatLoginBack wechatLoginBack = JSON.toJavaObject(JSON.parseObject(resp), WechatLoginBack.class);
        // 判断微信是否获取授权
        if (wechatLoginBack != null && wechatLoginBack.getOpenid() != null) {
            LambdaQueryWrapper<UserEntity> queryWrapper = new QueryWrapper<UserEntity>().lambda().eq(UserEntity::getOpenId, wechatLoginBack.getOpenid());
            UserEntity userEntity = userService.getBaseMapper().selectOne(queryWrapper);
            if (userEntity == null) {
                UserEntity userEntity1 = new UserEntity();
                Long userId = redisUserService.createPrimaryKey();
                userEntity1.setUserId(userId);
                userEntity1.setCreateBy(userId); // wechatLoginBack.getOpenid()
                userEntity1.setOpenId(wechatLoginBack.getOpenid());
                userEntity1.setRegType(3);
                int insert = userService.getBaseMapper().insert(userEntity1);
                if (insert > 0) {
                    HashMap<String, Object> tokenMap = new HashMap<>();
                    tokenMap.put("userId", userId);
                    String token = JwtManage.createToken(tokenMap);
                    HashMap<String, Object> userInfo = new HashMap<>();
                    userInfo.put("token", token);
                    userInfo.put("userId", userId);
                    userInfo.put("openId", userEntity1.getOpenId());
                    userInfo.put("wxAccessToken", wechatLoginBack.getAccessToken());
                    redisService.setString(BaseConstant.loginPrefix + userId, JSON.toJSONString(userInfo), BaseConstant.wxLoginTime);
                    return BackResult.success(userInfo);
                } else {
                    throw new CustomException(ResponseEnum.AUTH_FAIL);
                }
            } else {
                HashMap<String, Object> tokenMap = new HashMap<>();
                tokenMap.put("userId", userEntity.getUserId());
                String token = JwtManage.createToken(tokenMap);
                HashMap<String, Object> userInfo = new HashMap<>();
                userInfo.put("token", token);
                userInfo.put("userId", userEntity.getUserId());
                userInfo.put("openId", userEntity.getOpenId());
                userInfo.put("wxAccessToken", wechatLoginBack.getAccessToken());
                redisService.setString(BaseConstant.loginPrefix + userEntity.getUserId(), JSON.toJSONString(userInfo), BaseConstant.wxLoginTime);
                return BackResult.success(userInfo);
            }
        } else {
            throw new CustomException(0, "微信授权失败：错误代码 -> " + wechatLoginBack.getErrcode());
        }
    }

    /**
     * description 获取微信 jssdk 授权
     *
     * @param jsSdkVo
     * @return ynd.core.result.BackResult
     * @author yangdaqiong
     * @date 2021-06-19 13:37:23
     **/
    @Override
    public BackResult getWeChatJsSdk(JsSdkVo jsSdkVo) {
        PayConf payConf = redisUserService.getPayConf(jsSdkVo.getConfId());
        if (payConf == null) {
            PayConfEntity payConfEntity = payConfService.getBaseMapper().selectById(jsSdkVo.getConfId());
            if (payConfEntity != null) {
                payConf = new PayConf();
                BeanUtils.copyProperties(payConfEntity, payConf);
                redisService.setString("conf_" + payConfEntity.getConfId(), JSON.toJSONString(payConfEntity), BaseConstant.wxLoginTime);
            } else {
                throw new CustomException(0, "未查询到对应的配置新信息");
            }
        }
        String ticketKey = "ticket_" + payConf.getAppSecret();
        // 缓存获取access_token值 这个和个人的不一样
        String ticket = redisService.getString(ticketKey);
        if (ticket != null) {
            return BackResult.success(ticket);
        }
        String key = "access_token_" + payConf.getAppSecret();
        String accessToken = redisService.getString(key);
        redisService.delete(ticketKey);
        if (accessToken == null) {
            accessToken = WeChatUtil.getAccessToken(payConf.getAppId(), payConf.getAppSecret());
            redisService.setString(key, accessToken, BaseConstant.publicLoginTime);
        }
        return getBackResult(payConf, ticketKey, accessToken);
    }

    /**
     * description 根据key生成唯一主键id
     *
     * @param key 生成id的key值
     * @return result
     * @author yangdaqiong
     * @date 2021-11-12 23:26:26
     **/
    @Override
    public BackResult createPrimaryKey(String key) {
        return BackResult.success(redisService.createKey(key));
    }

    /**
     * description 公共部分提取
     *
     * @param payConf     配置
     * @param ticketKey   签名
     * @param accessToken token
     * @return result
     * @author yangdaqiong
     * @date 2021-11-12 23:36:30
     **/
    private BackResult getBackResult(PayConf payConf, String ticketKey, String accessToken) {
        String ticket;
        ticket = WeChatUtil.getJsApiTicket(accessToken);
        if (StringUtils.isNotEmpty(ticket)) {
            String randomUrl = "";
            Map<String, String> sign = WeChatUtil.sign(ticket, randomUrl);
            sign.put("appId", payConf.getAppId());
            redisService.setString(ticketKey, sign.toString(), BaseConstant.wxLoginTime);
            return BackResult.success(sign);
        } else {
            throw new CustomException(0, "获取微信ticket失败");
        }
    }
}
