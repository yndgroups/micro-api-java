package ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.utils;

import lombok.Data;

/**
 * description
 *@author yangdaqiong
 *@date 2019/11/22 0022 15:44
 **/
@Data
public class TokenParseWeChatUser {
    private String refreshToken;
    private String scope;
    private String openid;
    private String accessToken;
    private String expiresIn;
    private String token;
}
