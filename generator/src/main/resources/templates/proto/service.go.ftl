package service

import (
"context"
"core/cmodel"
"core/config"
"core/log"
"core/redis"
"core/resp"
"core/validate"
"github.com/gin-gonic/gin"
"protobuffer/build/<#if package.ModuleName?? && package.ModuleName != "">${package.ModuleName}</#if>"
)

// Create${entity} 收货地址新增信息
func Create${entity}(ctx *gin.Context) any {
    ${entity?uncap_first} := <#if package.ModuleName?? && package.ModuleName != "">${package.ModuleName}</#if>.${entity}{}
    if err := ctx.ShouldBindJSON(&${entity?uncap_first}); err != nil {
        return resp.Fail.WithData(err.Error())
    }
    // 校验请求参数
    if validateMsg, err := validate.Validated(&${entity?uncap_first}); err != nil {
        return resp.ErrParam.WithData(validateMsg)
    }
    ${entity?uncap_first}.CreateBy = ctx.Param("legalUserId")
    conon, err := GetConon()
    if err != nil {
        return resp.Fail.WithMsg("生产者服务获取异常！")
    }
    ${entity?uncap_first}.AddressId = redis.GetPrimaryKey("SYS_<#if package.ModuleName?? && package.ModuleName != "">${package.ModuleName}</#if>_REQUEST_COUNT")
    if result, getResultError := <#if package.ModuleName?? && package.ModuleName != "">${package.ModuleName}</#if>.New${entity}ServiceClient(conon).Create${entity}(context.Background(), &${entity?uncap_first}); getResultError != nil {
        log.SugarLogger.Errorf("服务生产者【%v】发生错误：错误信息：%v", config.GetConfig().Server.YsjzProvider, getResultError.Error())
        return resp.Fail.WithMsg("服务生产者调用异常,请联系管理员进行检查")
    } else {
        return resp.Back.Insert(result.Count)
    }
}

// Update${entity} 更新收货地址信息
func Update${entity}(ctx *gin.Context) any {
    ${entity?uncap_first} := <#if package.ModuleName?? && package.ModuleName != "">${package.ModuleName}</#if>.${entity}{}
    if err := ctx.ShouldBindJSON(&${entity?uncap_first}); err != nil {
        return resp.Fail.WithData(err.Error())
    }
    // 校验请求参数
    if validateMsg, err := validate.Validated(&${entity?uncap_first}); err != nil {
        return resp.ErrParam.WithData(validateMsg)
    }
    ${entity?uncap_first}.UpdateBy = ctx.Param("legalUserId")
    conon, err := GetConon()
    if err != nil {
        return resp.Fail.WithMsg("生产者服务获取异常！")
    }
    if result, getResultError := <#if package.ModuleName?? && package.ModuleName != "">${package.ModuleName}</#if>.New${entity}ServiceClient(conon).Update${entity}(context.Background(), &${entity?uncap_first}); getResultError != nil {
        log.SugarLogger.Errorf("服务生产者【%v】发生错误：错误信息：%v", config.GetConfig().Server.YsjzProvider, getResultError.Error())
        return resp.Fail.WithMsg("服务生产者调用异常,请联系管理员进行检查")
    } else {
        return resp.Back.Update(result.Count)
    }
}

// Delete${entity} 删除收货地址信息
func Delete${entity}(ctx *gin.Context) any {
    ids := cmodel.Ids{}
    if err := ctx.ShouldBindJSON(&ids); err != nil {
        return resp.Fail.WithMsg(err.Error())
    }
    conon, err := GetConon()
    if err != nil {
        return resp.Fail.WithMsg("生产者服务获取异常！")
    }
    if result, getResultError := <#if package.ModuleName?? && package.ModuleName != "">${package.ModuleName}</#if>.New${entity}ServiceClient(conon).Delete${entity}(context.Background(), &<#if package.ModuleName?? && package.ModuleName != "">${package.ModuleName}</#if>.${entity}Ids{
        AddressIds: ids,
        UserId:     ctx.Param("legalUserId"),
    }); getResultError != nil {
        log.SugarLogger.Errorf("服务生产者【%v】发生错误：错误信息：%v", config.GetConfig().Server.YsjzProvider, getResultError.Error())
        return resp.Fail.WithMsg("服务生产者调用异常,请联系管理员进行检查")
    } else {
        return resp.Back.Delete(result.Count)
    }
}

// Find${entity}List 查询收货地址列表
func Find${entity}List(ctx *gin.Context) any {
    conon, err := GetConon()
    if err != nil {
        return resp.Fail.WithMsg("生产者服务获取异常！")
    }
    if result, getResultError := <#if package.ModuleName?? && package.ModuleName != "">${package.ModuleName}</#if>.New${entity}ServiceClient(conon).Find${entity}List(context.Background(), &<#if package.ModuleName?? && package.ModuleName != "">${package.ModuleName}</#if>.${entity}Ids{
        AddressIds: nil,
        UserId:     ctx.Param("legalUserId"),
    }); getResultError != nil {
        log.SugarLogger.Errorf("服务生产者【%v】发生错误：错误信息：%v", config.GetConfig().Server.YsjzProvider, getResultError.Error())
        return resp.Fail.WithMsg("服务生产者调用异常,请联系管理员进行检查")
    } else {
        return resp.Back.Result(result.Count, result.List)
    }
}

// Find${entity}ById 查询收货地址详情
func Find${entity}ById(ctx *gin.Context) any {
    conon, err := GetConon()
    if err != nil {
        return resp.Fail.WithMsg("生产者服务获取异常！")
    }
    if result, getResultError := <#if package.ModuleName?? && package.ModuleName != "">${package.ModuleName}</#if>.New${entity}ServiceClient(conon).Find${entity}ById(context.Background(), &<#if package.ModuleName?? && package.ModuleName != "">${package.ModuleName}</#if>.${entity}Ids{
        AddressIds: []string{ctx.Param("id")},
        UserId:     ctx.Param("legalUserId"),
    }); getResultError != nil {
        log.SugarLogger.Errorf("服务生产者【%v】发生错误：错误信息：%v", config.GetConfig().Server.YsjzProvider, getResultError.Error())
        return resp.Fail.WithMsg("服务生产者调用异常,请联系管理员进行检查")
    } else {
        return resp.Back.Result(result.Count, result.Detail)
    }
}
