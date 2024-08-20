package ynd.common.entity;

import ynd.core.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_role_menu")
@ApiModel(value="RoleMenu对象", description="角色菜单关联表")
public class RoleMenuEntity  extends BaseEntity {

    @ApiModelProperty("角色id")
    @TableField("role_id")
    private String roleId;

    @ApiModelProperty("菜单id")
    @TableField("menu_id")
    private String menuId;

}
