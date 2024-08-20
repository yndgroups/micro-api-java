package ynd.core.emums;

/**
 * description 返回状态枚举
 *
 * @author Yang Daqiong
 * @date 2019-07-30 17:38
 */
public enum ResponseEnum {

    AUTH_SUCCESS(200, "授权成功"),
    REQ_SUCCESS(200, "请求成功"),
    INSERT_SUCCESS(200, "添加成功"),
    DELETE_SUCCESS(200, "删除成功"),
    UPDATE_SUCCESS(200, "修改成功"),
    UPLOAD_SUCCESS(200, "上传成功"),
    LOGIN_SUCCESS(200, "登录成功"),
    LOGOUT_SUCCESS(200, "您已退出本系统"),
    WX_AUTH_SUCCESS(200, "微信授权信息成功"),
    EMAIL_SEND_SUCCESS(200, "邮件发送成功！"),
    REQ_FAIL(20410, "请求失败"),
    BAD_REQUEST(20411, "非法请求"),
    REQ_NOT_DATA(20412, "没有查询到数据"),
    INSERT_FAIL(20413, "添加失败"),
    DELETE_FAIL(20414, "删除失败"),
    UPDATE_FAIL(20415, "修改失败"),
    UPLOAD_FAIL(20414, "上传失败"),
    EMAIL_SEND_FAIL(20415, "邮件发送失败！"),
    MUST_FILED_NOT_BLANK(400001, "必传字段为空"),
    PARAMS_NO_PASS(400002, "参数校验不通过"),
    LOGIN_NOT(401000, "您还未登录"),
    USER_NOT_EXIST(40101, "用户不存在!"),
    PASSWORD_NO_BLANK(40102, "密码不能为空"),
    PASSWORD_ERROR(40103, "密码错误"),
    LOGIN_FAIL(40104, "登录失败"),
    LOGOUT_FAIL(40101, "退出失败"),
    AUTH_FAIL(40105, "授权失败"),
    WECHAT_AUTH_FAIL(40106, "微信授权失败"),
    TOKEN_NOT_EXIST(40101, "未登陆或TOKEN认已失效！请重新登录"),
    TOKEN_PARSE_FAIL(40108, "TOKEN解析失败"),
    TOKEN_PARSE_ERROR(40109, "无效TOKEN"),
    TOKEN_CREATE_FAIL(40110, "TOKEN创建失败"),
    TOKEN_FORMAT_ERROR(40111, "TOKEN格式错误"),
    TOKEN_PARMA_NOT(40112, "TOKEN参数不能为空"),
    INTERFACE_NO_ACCESS(40113, "您暂无此接口访问权限"),
    DELETE_FILE_FAIL(40114, "文件删除失败"),
    DELETE_FILE_SUCCESS(40115, "文件删除成功"),
    DELETE_FOLDER_FAIL(40116, "文件夹删除失败"),
    DELETE_FOLDER_SUCCESS(0, "文件夹删除成功"),
    NO_AUTHORITY(40501, "您没有该应用的权限"),
    SENTINEL_FLOW(40502, "接口限流了"),
    SENTINEL_DEGRADE(40503, "服务降级了"),
    SENTINEL_PARAM_FLOW(40504, "接口限流了"),
    SENTINEL_SYSTEM_BLOCK(40505, "接口限流了"),
    SENTINEL_AUTHORITY(40506, "接口限流了"),
    SENTINEL_EXCEPTION(40507, "接口限流了"),
    REDIS_LINK_FAIL(40801, "Redis连接失败"),
    MICROSERVICES_LINK_FAIL(40802, "服务调用失败"),
    MICROSERVICES_CONNECTION_REFUSED(40803, "服务拒绝链接"),
    MICROSERVICES_READ_TIMED_OUT(40804, "服务接口请求超时"),
    UNKNOWN_EXCEPTION(50011, "未知异常！");
    private Integer code;
    private String message;

    ResponseEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
