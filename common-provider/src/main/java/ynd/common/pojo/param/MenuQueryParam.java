package ynd.common.pojo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-10-05
 */
@Data
@Accessors(chain = true)
@ApiModel(value="菜单权限查询条件", description="菜单表")
public class MenuQueryParam {

    @ApiModelProperty(value = "应用id", required = true)
    @NotBlank(message = "appId不能为空")
    private String appId;

    @ApiModelProperty(value = "角色id")
    private String roleId;

}
