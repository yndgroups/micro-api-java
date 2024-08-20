package ynd.core.model;

import lombok.Data;

import java.util.List;

/**
 * description 加解密
 *
 * @author yangdaqiong
 * @date 2019-07-28 18:21
 **/
@Data
public class TokenParseUserAuth {

    /* 用户id */
    private Long userId;

    /* 用户名 */
    private String userName;

    /* 地区编码 */
    private String areaCode;

    /* 地区级别 */
    private int areaTag;

    /* 地区名称 */
    private String areaName;

    /* token */
    private String token;

    /* 应用id */
    private String appId;

    /* 微信openId */
    private String openId;

    /* 账号类型 */
    private String accountType;

    /* 角色列表 */
    private List<Long> roles;

    private String wxAccessToken;

    public  TokenParseUserAuth() {}

    public TokenParseUserAuth(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public TokenParseUserAuth(Long userId, String userName, String areaCode, int areaTag, String areaName, String token, String appId, String openId, String accountType, List<Long> roles, String wxAccessToken) {
        this.userId = userId;
        this.userName = userName;
        this.areaCode = areaCode;
        this.areaTag = areaTag;
        this.areaName = areaName;
        this.token = token;
        this.appId = appId;
        this.openId = openId;
        this.accountType = accountType;
        this.roles = roles;
        this.wxAccessToken = wxAccessToken;
    }
}
