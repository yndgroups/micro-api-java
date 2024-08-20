package ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.vo;

import ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.configuration.ResponseEnum;
import ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.configuration.CustomException;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import lombok.experimental.Accessors;


/**
 * description 统一结果返回类
 *@return
 *@param
 *@author yangdaqiong
 *@date 2019/9/26 0:44
 **/
@ApiModel("统一返回: Vo")
@Accessors(chain = true)
@Data
public class BackVO<T> {

    private T data;

    private Integer code;

    private String msg;

    public BackVO(){}

    public BackVO(T data, ResponseEnum responseEnum){
        this.data = data;
        this.code = responseEnum.getCode();
        this.msg = responseEnum.getMsg();
    }

    public BackVO(ResponseEnum responseEnum){
        this.data = null;
        this.code = responseEnum.getCode();
        this.msg = responseEnum.getMsg();
    }

    public BackVO(CustomException exp){
        this.data = null;
        this.code = exp.getCode();
        this.msg = exp.getMessage();
    }

    public static BackVO success(Object data){
        return new BackVO(data, ResponseEnum.REQ_SUCCESS);
    }

    public static BackVO insert(int result){
        if(result > 0) {
            return new BackVO("成功插入" + result + "条数据", ResponseEnum.INSERT_SUCCESS);
        }else {
            return new BackVO(ResponseEnum.INSERT_FAIL);
        }
    }

    public static BackVO insert(boolean result){
        if(result) {
            return new BackVO("数据插入成功", ResponseEnum.INSERT_SUCCESS);
        }else {
            return new BackVO(ResponseEnum.INSERT_FAIL);
        }
    }

    public static BackVO update(int result){
        if(result > 0) {
            return new BackVO("成功更新" + result + "条数据", ResponseEnum.UPDATE_SUCCESS);
        }else {
            return new BackVO(ResponseEnum.UPDATE_FAIL);
        }
    }

    public static BackVO update(boolean result){
        if(result) {
            return new BackVO("数据更新成功", ResponseEnum.UPDATE_SUCCESS);
        }else {
            return new BackVO(ResponseEnum.UPDATE_FAIL);
        }
    }

    public static BackVO delete(int result){
        if(result > 0) {
            return new BackVO("成功删除" + result + "条数据", ResponseEnum.DELETE_SUCCESS);
        }else {
            return new BackVO(ResponseEnum.DELETE_FAIL);
        }
    }

    public static BackVO delete(boolean result){
        if(result) {
            return new BackVO("数据删除成功", ResponseEnum.DELETE_SUCCESS);
        }else {
            return new BackVO(ResponseEnum.DELETE_FAIL);
        }
    }
}