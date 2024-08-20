package ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.utils;

import lombok.Data;

/**
 *@description 加解密
 *@return
 *@params
 *@author yangdaqiong
 *@date 2019-07-28 18:21
 **/
@Data
public class TokenParseUser {

    private String userId;

    private String userName;

    private String areaCode;

    private int areaTag;

    private String areaName;

    private String token;

    private String roleId;

    private String appId;
}