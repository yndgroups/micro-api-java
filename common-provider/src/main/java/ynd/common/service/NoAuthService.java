package ynd.common.service;

import ynd.core.result.BackResult;
import ynd.common.pojo.vo.JsSdkVo;
import ynd.common.pojo.vo.LoginBackVo;
import ynd.common.pojo.vo.WeChatUserInsertVo;
import ynd.common.pojo.vo.WeChatWebLoginVo;

/**
 * @author yangdaqiong
 * @description 不需要验证的接口
 * @date 2021-05-13 22:08:45
 **/
public interface NoAuthService {

    /**
     * @param loginBackVo
     * @return 返回登录信息
     * @description 后台登录
     * @author yangdaqiong
     * @date 2021-05-13 22:09:47
     **/
    BackResult login(LoginBackVo loginBackVo);

    /**
     * description 微信登录
     *
     * @param weChatUserInsertVo 微信登录参数
     * @return ynd.core.result.BackResult
     * @author yangdaqiong
     * @date 2021-06-19 09:14:08
     **/
    BackResult wechatLogin(WeChatUserInsertVo weChatUserInsertVo) throws Exception;

    /**
     * description 微信公众号登录
     *
     * @param weChatWebLoginVo 微信公众号登录参数
     * @return BackResult
     * @author yangdaqiong
     * @date 2021-08-08 17:28:09
     **/
    BackResult wechatWebLogin(WeChatWebLoginVo weChatWebLoginVo) throws Exception;

    /**
     * description 获取jsSDK授权
     *
     * @param jsSdkVo jssdk获取参数
     * @return ynd.core.result.BackResult
     * @author yangdaqiong
     * @date 2021-06-19 12:32:41
     **/
    BackResult getWeChatJsSdk(JsSdkVo jsSdkVo);

    /**
     * description 根据key值生成唯一主键
     *
     * @param key key值
     * @return result
     * @author yangdaqiong
     * @date 2021-11-12 23:19:00
     **/
    BackResult createPrimaryKey(String key);
}
