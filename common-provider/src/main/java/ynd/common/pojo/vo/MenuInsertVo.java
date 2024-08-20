package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

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
@ApiModel(value="菜单新增", description="菜单管理")
public class MenuInsertVo {

    @ApiModelProperty(value = "菜单父ID, 一级菜单父ID为1（默认是‘1’）", required = true)
    private Long parentId;

    @ApiModelProperty(value = "菜单名称", required = true)
    private String name;

    @ApiModelProperty(value = "菜单图标")
    private String icon;

    @ApiModelProperty(value = "菜单地址")
    private String url;

    @ApiModelProperty(value = "权限标识")
    private String powerSign;

    @ApiModelProperty(value = "是否是菜单（1是，0:按钮，默认是1）", required = true)
    @NotNull(message = "菜单类型不能为空")
    @Range(min = 0, max = 1, message = "菜单类型不能为空取值不正确")
    private Integer type;

    @ApiModelProperty(value = "排列等级")
    private Integer sortBy;

    @ApiModelProperty(value = "菜单属于哪个应用", required = true)
    @NotNull(message = "appId不能为空")
    private Long appId;

}
