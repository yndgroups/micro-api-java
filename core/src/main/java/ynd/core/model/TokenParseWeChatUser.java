package ynd.core.model;

import lombok.Data;

/**
 * description 微信实体类解析实体
 *
 *@author yangdaqiong
 *@date 2019-11-22 15:44
 **/
@Data
public class TokenParseWeChatUser {

    /* 用于刷新Access Token 的 Refresh Token,所有应用都会返回该参数 */
    private String refreshToken;

    /*  Access Token最终的访问范围，关于权限的具体信息参考scope权限列表 */
    private String scope;

    /*  用户统一标识，可以唯一标识一个用户.网站或应用可将此ID进行存储，便于用户下次登录时辨识其身份 */
    private String openid;

    /* 授权 */
    private String Authorization;

    /* Access Token的有效期，以秒为单位, 请参考Access Token生命周期 */
    private String expiresIn;

    /* 要获取的Access Token */
    private String token;

}
