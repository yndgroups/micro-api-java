package ynd.common.pojo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 2020区划代码
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "地区搜索条件", description = "2020区划代码")
public class AreaParam {

    @ApiModelProperty(value = "地区码")
    private String areaCode;

    @ApiModelProperty(value = "地区名称")
    private String areaName;

}
