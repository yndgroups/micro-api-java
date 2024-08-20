package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@EqualsAndHashCode(callSuper=false)
@Accessors(chain = true)
@ApiModel(value="菜单更新", description="菜单管理")
public class MenuUpdateVo  extends MenuInsertVo{

    @ApiModelProperty(value = "菜单ID", required = true)
    @NotNull(message = "菜单id不能为空")
    private Long menuId;

}
