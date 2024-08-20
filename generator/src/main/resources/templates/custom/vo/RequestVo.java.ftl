package ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.vo;

import ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.configuration.CustomException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 *@description 统一分页扩展类
 *@return
 *@params
 *@author yangdaqiong
 *@date 2019-07-24 23:32
 **/
@ApiModel("统一分页扩展类: Vo")
@Data
public class RequestVo<T> {
    @Min(value = 1, message = "当前请求页必须大于等于1")
    @ApiModelProperty(value = "当前请求页码", required = true)
    private Integer pageIndex;

    @Min(value = 1, message = "前请求每页条数必须大于等于1")
    @ApiModelProperty(value = "当前请求条数", required = true)
    private Integer pageSize;

    @ApiModelProperty(value = "当前请求条件查询参数")
    private T params;

    public RequestVo() {}

    public RequestVo(Integer pageIndex, Integer pageSize, T params) {
        if (pageIndex <= 0){
            throw new CustomException(0, "pageIndex必须大于0");
        }
        if (pageIndex == 1 ){
            pageIndex = 0;
        }
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.params = params;
    }
}