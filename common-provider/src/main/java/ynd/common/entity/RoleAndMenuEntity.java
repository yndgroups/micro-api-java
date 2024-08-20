package ynd.common.entity;

import ynd.core.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * description 菜单用户授权给角色
 *
 * @author yangdaqiong
 * @date 2019-11-24 02:18
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel("菜单用户授权给角色")
@TableName("sys_menu_role")
public class RoleAndMenuEntity extends BaseEntity {

    @ApiModelProperty(value = "应用id")
    @TableField("app_id")
    private Long appId;

    @ApiModelProperty(value = "角色id")
    @TableField("role_id")
    private Long roleId;

    @ApiModelProperty(value = "菜单id")
    @TableField("menu_id")
    private Long menuId;

    @ApiModelProperty(value = "权限标识")
    @TableField("power_sign")
    private String powerSign;

    @ApiModelProperty(value = "绑定描述")
    @TableField("describe")
    private String describe;

    @ApiModelProperty(value = "功能id描述")
    @TableField("func_id")
    private Long funcId;

}
