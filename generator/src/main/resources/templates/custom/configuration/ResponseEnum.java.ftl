package ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.configuration;

/**
 *@description 返回状态枚举
 *@return
 *@params
 *@author yangdaqiong
 *@date 2019-07-30 17:38
 **/
public enum ResponseEnum {

    /**
     * 未知异常
     */
    UNKNOWN_EXCEPTION(0, "未知异常！"),

    /**
     * 必传字段为空
     */
    MUST_FILED_NOT_BLANK(0, "必传字段为空"),
    /**
     * 必传字段为空
     */
    PARAMS_NO_PASS(0, "参数校验不通过"),

    /**
     * 未登陆或TOKEN认已失效！请重新登录
     */
    TOKEN_NOT_EXIST(401, "未登陆或TOKEN认已失效！请重新登录"),

    /**
     * 您没有该应用的权限
     */
    NO_AUTHORITY(403, "您没有该应用的权限"),

    /**
     * TOKEN解析失败
     */
    TOKEN_PARSE_FAIL(0, "TOKEN解析失败"),

    /**
     * TOKEN创建失败
     */
    TOKEN_CRATE_FAIL(0, "TOKEN创建失败"),

    /**
     * TOKEN格式错误
     */
    TOKEN_FORMAT_ERROR(0, "TOKEN格式错误"),

    /**
     * 无效TOKEN
     */
    TOKEN_PARSE_ERROR(401, "无效TOKEN"),

    /**
     * TOKEN参数不能为空
     */
    TOKEN_NOT(0, "TOKEN参数不能为空"),

    /**
     * 请求成功
     */
    REQ_SUCCESS(200, "请求成功"),

    /**
     * 没有查询到数据
     */
    REQ_NOT_DATA(0, "没有查询到数据"),

    /**
     * 请求失败
     */
    REQ_FAIL(0, "请求失败"),

    /**
     * 授权成功
     */
    AUTH_SUCCESS(200, "授权成功"),

    /**
     * 授权失败
     */
    AUTH_FAIL(0, "授权失败"),

    /**
     * 添加成功
     */
    INSERT_SUCCESS(200, "添加成功"),

    /**
     * 添加失败
     */
    INSERT_FAIL(0, "添加失败"),

    /**
     * 修改成功
     */
    UPDATE_SUCCESS(200, "修改成功"),

    /**
     * 修改失败
     */
    UPDATE_FAIL(0, "修改失败"),

    /**
     * 删除成功
     */
    DELETE_SUCCESS(200, "删除成功"),

    /**
     * 删除失败
     */
    DELETE_FAIL(0, "删除失败"),

    /**
     * 密码错误
     */
    PASSWORD_ERROR(0, "密码错误"),

    /**
     * 密码不能为空
     */
    PASSWORD_NO_BLANK(0, "密码不能为空"),

    /**
     * 密码正确
     */
    PASSWORD_RIGHT(0, "密码正确"),

    /**
     * 登录成功
     */
    LOGIN_SUCCESS(200, "登录成功"),

    /**
     * 您还未登录
     */
    LOGIN_NOT(401, "您还未登录"),

    /**
     * 登录失败
     */
    LOGIN_FAIL(0, "登录失败"),

    /**
     * 您已退出本系统
     */
    LOGOUT_SUCCESS(200, "您已退出本系统"),

    /**
     * 退出失败
     */
    LOGOUT_FAIL(0, "退出失败"),

    /**
     * 用户不存在!
     */
    USER_NOT_EXIST(0, "用户不存在!"),

    /**
     * 上传成功
     */
    UPLOAD_SUCCESS(200, "上传成功"),

    /**
     * 上传失败
     */
    UPLOAD_FAIL(0, "上传失败"),

    /**
     * 微信获取授权信息失败
     */
    WX_AUTH_FAIL(0, "微信获取授权信息失败"),

    /**
     * 微信获取授权信息成功
     */
    WX_AUTH_SUCCESS(200, "微信获取授权信息成功"),

    /**
     * 邮件发送成功
     */
    EMAIL_SEND_SUCCESS(200, "邮件发送成功！"),
    /**
     * 邮件发送失败
     */
    EMAIL_SEND_FAIL(0, "邮件发送失败！"),
    /**
     * 您暂无此接口访问权限
     */
    INTERFACE_NO_ACCESS(0, "您暂无此接口访问权限");

    private Integer code;
    private String message;

    ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return message;
    }

    public void setMsg(String msg) {
        this.message = msg;
    }
}