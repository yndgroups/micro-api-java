package ynd.core.result;

import ynd.core.exception.CustomException;
import ynd.core.emums.ResponseEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * description 高级封装返回结果
 *
 * @author yangdaqiong
 * @date 2019-09-26 0:44
 **/
@ApiModel("统一返回封装")
@Accessors(chain = true)
@Data
public class BackResult<T> {

    @ApiModelProperty(value = "操作结果", required = true)
    private T data;

    @ApiModelProperty(value = "状态码", required = true)
    private Integer code;

    @ApiModelProperty(value = "状态信息", required = true)
    private String msg;

    /**
     * 空参构造
     */
    public BackResult() {
    }

    /**
     * 有参构造
     * @param data 操作结果返回
     * @param responseEnum 操作结果枚举
     */
    public BackResult(T data, ResponseEnum responseEnum) {
        this.data = data;
        this.code = responseEnum.getCode();
        this.msg = responseEnum.getMessage();
    }

    /**
     * 枚举返回请求信息
     *
     * @param responseEnum
     */
    public BackResult(ResponseEnum responseEnum) {
        this.data = null;
        this.code = responseEnum.getCode();
        this.msg = responseEnum.getMessage();
    }

    /**
     * 枚举返回异常信息
     * @param exp
     */
    public BackResult(CustomException exp) {
        this.data = null;
        this.code = exp.getCode();
        this.msg = exp.getMessage();
    }

    /**
     * 请求反馈
     * @param data
     * @return
     */
    public static BackResult success(Object data) {
        if (data == null) {
            return new BackResult(data, ResponseEnum.REQ_NOT_DATA);
        }
        return new BackResult(data, ResponseEnum.REQ_SUCCESS);
    }

    /**
     * 请求反馈
     * @return
     */
    public static BackResult fail() {
        return new BackResult(ResponseEnum.REQ_FAIL);
    }

    /**
     * 请求反馈
     * @param data
     * @return
     */
    public static BackResult fail(Object data) {
        return new BackResult(data, ResponseEnum.REQ_FAIL);
    }

    /**
     * 插入反馈
     * @param result
     * @return
     */
    public static BackResult insert(int result) {
        if (result > 0) {
            return new BackResult("成功插入" + result + "条数据", ResponseEnum.INSERT_SUCCESS);
        } else {
            return new BackResult(ResponseEnum.INSERT_FAIL);
        }
    }

    /**
     * 插入失败
     * @return
     */
    public static BackResult insertFail() {
        return new BackResult(ResponseEnum.INSERT_FAIL);
    }

    /**
     * 插入反馈
     * @param result
     * @return
     */
    public static BackResult insert(boolean result) {
        if (result) {
            return new BackResult("数据插入成功", ResponseEnum.INSERT_SUCCESS);
        } else {
            return new BackResult(ResponseEnum.INSERT_FAIL);
        }
    }

    /**
     * 更新反馈
     * @param result
     * @return
     */
    public static BackResult update(int result) {
        if (result > 0) {
            return new BackResult("成功更新" + result + "条数据", ResponseEnum.UPDATE_SUCCESS);
        } else {
            return new BackResult(ResponseEnum.UPDATE_FAIL);
        }
    }

    /**
     * 更新反馈
     * @param result
     * @return
     */
    public static BackResult update(boolean result) {
        if (result) {
            return new BackResult("数据更新成功", ResponseEnum.UPDATE_SUCCESS);
        } else {
            return new BackResult(ResponseEnum.UPDATE_FAIL);
        }
    }

    /**
     * 删除反馈
     * @param result
     * @return
     */
    public static BackResult delete(int result) {
        if (result > 0) {
            return new BackResult("成功删除" + result + "条数据", ResponseEnum.DELETE_SUCCESS);
        } else {
            return new BackResult(ResponseEnum.DELETE_FAIL);
        }
    }

    /**
     * 删除反馈
     * @param result
     * @return
     */
    public static BackResult delete(boolean result) {
        if (result) {
            return new BackResult("数据删除成功", ResponseEnum.DELETE_SUCCESS);
        } else {
            return new BackResult(ResponseEnum.DELETE_FAIL);
        }
    }

}
