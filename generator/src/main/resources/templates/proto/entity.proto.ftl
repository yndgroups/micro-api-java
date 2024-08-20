syntax = "proto3";

package <#if package.ModuleName?? && package.ModuleName != "">${package.ModuleName}</#if>;

option go_package = "build/<#if package.ModuleName?? && package.ModuleName != "">${package.ModuleName}</#if>";
import "protos/global/global.proto";

message ${entity} {
<#list table.fields as field>
    // ${field.comment}
    <#if field.propertyType=="String">
    string ${field.propertyName} = ${field_index + 1}; // @gotags: <#if field.keyFlag>gorm:"primary_key;<-:create"<#else>gorm:"<-"</#if>
    </#if>
    <#if field.propertyType=="Integer">
    int32 ${field.propertyName} = ${field_index + 1}; // @gotags: <#if field.keyFlag>gorm:"primary_key;<-:create"<#else>gorm:"<-"</#if>
    </#if>
    <#if field.propertyType=="Long">
        <#if field.propertyName=="createBy">
    string createBy = ${field_index + 1}; // @gotags: gorm:"->;<-:create" swaggerignore:"true" minLength:"6" maxLength:"19"
        <#elseif field.propertyName=="createBy">
    string  updateBy = ${field_index + 1}; // @gotags: gorm:"->;<-:update" swaggerignore:"true" minLength:"6" maxLength:"19"
        <#else>
    string ${field.propertyName} = ${field_index + 1}; // @gotags: <#if field.keyFlag>gorm:"primary_key;<-:create"<#else>gorm:"<-"</#if>
        </#if>
    </#if>
    <#if field.propertyType=="Byte">
        <#if field.propertyName=="delStatus">
    bool delStatus = ${field_index + 1}; // @gotags: gorm:"-" swaggerignore:"true" minimum:"0" maximum:"1" default:"0"
        <#else>
    int32 ${field.propertyName} = ${field_index + 1}; // @gotags: gorm:"<-"
        </#if>
    </#if>
    <#if field.propertyType=="LocalDateTime">
        <#if field.propertyName=="createTime">
    string  createTime = ${field_index + 1}; // @gotags: gorm:"->" swaggerignore:"true"
        </#if>
        <#if field.propertyName=="updateTime">
    string updateTime = ${field_index + 1}; // @gotags: gorm:"->" swaggerignore:"true"
        </#if>
    </#if>
</#list>
}


message ${entity}Param {

}

message ${entity}Ids {
<#list table.fields as field>
    <#if field.keyFlag>
    // ${field.comment}集合
    repeated string ${field.propertyName} = 1;
    </#if>
</#list>
    // 用户id
    string userId = 2;
}

// 分页查询加权参数
message ${entity}PageAuthQuery {
    // 分页索引
    int64 pageIndex = 1;
    // 分页长度
    int64 pageSize = 2;
    // 查询参数
    ${entity}Param params = 3;
    // 用户登录授权信息
    global.Auth auth = 4; // @gotags: swaggerignore:"true"`
}

// 返回结果
message ${entity}Response {
    // 获取数据数量
    int64 count = 1;
    // 错误信息
    string errMsg = 2;
    // 详情
    ${entity} detail = 3;
    // 列表
    repeated ${entity} list = 4;
}

// 业务实现
service ${entity}Service {

    // 新增
    rpc Create${entity} (${entity}) returns (${entity}Response);

    // 修改
    rpc Update${entity} (${entity}) returns (${entity}Response);

    // 删除
    rpc Delete${entity} (${entity}Ids) returns (${entity}Response);

    // 查询 详情
    rpc Find${entity}ById (${entity}Ids) returns (${entity}Response);

    // 查询 分页
    rpc Find${entity}PageList (${entity}PageAuthQuery) returns (${entity}Response);

}

