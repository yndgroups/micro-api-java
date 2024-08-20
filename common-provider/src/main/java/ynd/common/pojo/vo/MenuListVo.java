package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@Accessors(chain = true)
@ApiModel(value="菜单列表", description="菜单管理")
public class MenuListVo {

    @ApiModelProperty(value = "菜单id")
    private String menuId;

    @ApiModelProperty(value = "菜单父ID, 一级菜单父ID为1（默认是‘1’）")
    private String parentId;

    @ApiModelProperty(value = "菜单图标")
    private String icon;

    @ApiModelProperty(value = "组件名称")
    private String name;

    @ApiModelProperty(value = "菜单地址")
    private String url;

    @ApiModelProperty(value = "权限标识")
    private String powerSign;

    @ApiModelProperty(value = "是否是菜单（1是，0是否，默认是1）")
    private String type;

    @ApiModelProperty(value = "排列等级")
    private String sortBy;

    @ApiModelProperty(value = "菜单属于哪个应用")
    private String appId;

    @ApiModelProperty(value = "删除状态(1：未删除，0：已删除，默认是1)")
    private boolean delStatus;

    @ApiModelProperty(value = "子菜单")
    private List<MenuListVo> children;

}
