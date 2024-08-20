package apis

import (
"net/http"
"ysjz/ysjz-consumer/service"

"github.com/gin-gonic/gin"
)

// Create${entity}
// @Tags 收货地址管理
// @Summary 收货地址添加
// @Description 主要用于用户进行收货地址添加
// @Param accessToken header string true "授权令牌" default(Bearer token)
// @Param object body <#if package.ModuleName?? && package.ModuleName != "">${package.ModuleName}</#if>.${entity} true "收货地址新增参数"
// @Success 200 {object} resp.Response 成功后返回数据结构
// @Failure 400,500 {object} resp.Response 失败后返回数据结构
// @Router /${entity?uncap_first} [post]
func Create${entity}(ctx *gin.Context) {
ctx.JSON(http.StatusOK, service.Create${entity}(ctx))
}

// Update${entity}
// @Tags 收货地址管理
// @Summary 收货地址修改
// @Description 主要用于用户进行收货地址修改
// @Param accessToken header string true "授权令牌" default(Bearer token)
// @Param object body <#if package.ModuleName?? && package.ModuleName != "">${package.ModuleName}</#if>.${entity} true "收货地址参数"
// @Success 200 {object} resp.Response "请求成功"
// @Failure 400,500 {object} resp.Response "请求异常"
// @Router /${entity?uncap_first} [put]
func UpdateUser${entity}(ctx *gin.Context) {
ctx.JSON(http.StatusOK, service.Update${entity}(ctx))
}

// Delete${entity}
// @Tags 收货地址管理
// @Summary 收货地址删除
// @Description 主要用于用户进行收货地址删除
// @Param accessToken header string true "授权令牌" default(Bearer token)
// @Param ids body cmodel.Ids  true "收货地址id集合"
// @Success 200 {object} resp.Response 成功后返回数据结构
// @Failure 400,500 {object} resp.Response 失败后返回数据结构
// @Router /${entity?uncap_first} [delete]
func Delete${entity}(ctx *gin.Context) {
ctx.JSON(http.StatusOK, service.Delete${entity}(ctx))
}

// Find${entity}List
// @Tags 收货地址管理
// @Summary 收货地址列表查询
// @Description 主要用于收货地址分页列表查询
// @Param accessToken header string true "授权令牌" default(Bearer token)
// @Success 200 {object} resp.Response{data=[]ysjz.${entity}} "请求成功"
// @Failure 400,500 {object}  resp.Response "请求异常"
// @Router /${entity?uncap_first}/find${entity}List [get]
func Find${entity}List(ctx *gin.Context) {
ctx.JSON(http.StatusOK, service.Find${entity}List(ctx))
}

// Find${entity}ById
// @Tags 收货地址管理
// @Summary 根据id收货地址详情查询
// @Description 主要用于收货地址详情查询
// @Param accessToken header string true "授权令牌" default(Bearer token)
// @Param id query string  true "收货地址id"
// @Success 200 {object} resp.Response "请求成功"
// @Failure 400,500 {object}  resp.Response "请求异常"
// @Router /${entity?uncap_first}/findById/{id} [get]
func Find${entity}ById(ctx *gin.Context) {
ctx.JSON(http.StatusOK, service.Find${entity}ById(ctx))
}
