package ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.vo;

import ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.utils.CommonUtil;
import ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.utils.TokenParseUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *@description
 *@return
 *@params 统一分页扩展类
 *@author yangdaqiong
 *@date 2019-07-24 23:02
 **/
@ApiModel("统一分页扩展类: Vo")
@EqualsAndHashCode(callSuper=false)
@Data
public class RequestAuthVo extends RequestVo {

    @ApiModelProperty(value = "当前请求权限条件")
    private TokenParseUser auth;

    public RequestAuthVo(){}

    public RequestAuthVo(Integer pageIndex, Integer pageSize, Object params, TokenParseUser auth){
        super(pageIndex, pageSize, params);
        auth.setAreaCode(CommonUtil.substringAreaCode(auth.getAreaCode(),auth.getAreaTag()));
        this.auth = auth;
    }
}