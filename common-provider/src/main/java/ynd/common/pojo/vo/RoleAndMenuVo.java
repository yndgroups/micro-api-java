package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * description 角色关联菜单Vo
 *
 * @author yangdaqiong
 * @date 2021-06-01 22:37:06
 **/
@ApiModel("菜单关联角色")
@Accessors(chain = true)
@Data
public class RoleAndMenuVo {

    @ApiModelProperty(value = "菜单id", required = true)
    @NotBlank(message = "菜单id不能为空")
    private String menuId;

    @ApiModelProperty(value = "角色id: 只能传一个id", required = true)
    @NotBlank(message = "角色id不能为空")
    private String roleId;

    @ApiModelProperty(value = "应用id: 只能传一个id", required = true)
    @NotBlank(message = "应用id不能为空")
    private String appId;

    @ApiModelProperty(value = "权限标识: 只能传一个标识", required = true)
    @NotBlank(message = "权限值")
    private String powerSign;

    @ApiModelProperty(value = "功能id", required = true)
    @NotBlank(message = "功能id不能为空")
    private String funcId;

    @ApiModelProperty(value = "绑定描述", required = true)
    @NotBlank(message = "绑定描述")
    private String describe;

}
