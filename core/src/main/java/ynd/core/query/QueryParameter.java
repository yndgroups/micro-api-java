package ynd.core.query;

import ynd.core.exception.CustomException;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * description 查询类类统一封装
 *
 * @author yangdaqiong
 * @date 2021-05-10 00:17:06
 **/
@Accessors(chain = true)
@Data
public class QueryParameter<T> {

    @ApiModelProperty(value = "当前请求页数", required = true)
    @Min(value = 1, message = "当前请求页必须大于等于1")
    private Integer pageIndex;

    @ApiModelProperty(value = "每页条数", required = true)
    @Min(value = 1, message = "前请求每页条数必须大于等于1")
    private Integer pageSize;

    @ApiModelProperty(value = "请求参数")
    @Valid
    private T params;

    public QueryParameter() {
    }

    public QueryParameter(QueryParameter requestVo) {
        if (requestVo.getPageIndex() <= 0) {
            throw new CustomException(0, "起始页[pageIndex]必须大于0");
        } else if (requestVo.getPageIndex() == 1) {
            pageIndex = 0;
        }
        this.pageIndex = (requestVo.getPageIndex() - 1) * requestVo.getPageSize();
        this.pageSize = requestVo.getPageSize();
        this.params = (T) requestVo.getParams();
    }
}
