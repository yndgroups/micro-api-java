package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 2020区划代码
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "地区修改", description = "2020区划代码")
public class AreaUpdateVo extends AreaInsertVo {

    @ApiModelProperty(value = "地区id", required = true)
    @NotBlank(message = "地区id不能为空")
    private String areaId;

}
