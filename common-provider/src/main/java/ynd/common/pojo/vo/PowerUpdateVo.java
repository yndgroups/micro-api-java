package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 *
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "权限修改", description = "权限管理")
public class PowerUpdateVo extends PowerInsertVo {

    @ApiModelProperty(value = "权限id", required = true)
    @NotNull(message = "权限id不能为空")
    private String powerId;

}
