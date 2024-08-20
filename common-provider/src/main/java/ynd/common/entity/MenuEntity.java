package ynd.common.entity;

import ynd.core.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_menu")
@ApiModel(value="MenuEntity对象", description="菜单表")
public class MenuEntity extends BaseEntity {

    @ApiModelProperty(value = "菜单ID(45位UUID)")
    @TableId(value = "menu_id", type = IdType.ASSIGN_UUID)
    private Long menuId;

    @ApiModelProperty(value = "菜单父ID, 一级菜单父ID为1（默认是‘1’）")
    @TableField("parent_id")
    private Long parentId;

    @ApiModelProperty(value = "菜单图标")
    @TableField("icon")
    private String icon;

    @ApiModelProperty(value = "组件名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "菜单地址")
    @TableField("url")
    private String url;

    @ApiModelProperty(value = "权限标识")
    @TableField("power_sign")
    private String powerSign;

    @ApiModelProperty(value = "是否是菜单（1是，0:否，默认是1）")
    @TableField("type")
    private Integer type;

    @ApiModelProperty(value = "排列等级")
    @TableField("sort_by")
    private Integer sortBy;

    @ApiModelProperty(value = "菜单属于哪个应用")
    @TableField("app_id")
    private Long appId;

}
