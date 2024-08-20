package ynd.core.model;

import lombok.Data;

/**
 * description 微信登录成功返回数据
 *
 * private String session_key;
 * private String access_token;
 *
 * @author yangdaqiong
 * @date 2021-06-19 09:47:07
 **/
@Data
public class WechatLoginBack {
    private String refreshToken;
    private String accessToken;
    private String sessionKey;
    private String expiresIn;
    private String token;
    private String scope;
    private String openid;
    private String errcode;
    private String errmsg;
}
