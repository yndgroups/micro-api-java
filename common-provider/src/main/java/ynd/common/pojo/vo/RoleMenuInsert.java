package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@ApiModel("角色菜单关联实体")
public class RoleMenuInsert {

    @ApiModelProperty("菜单id列表")
    @NotNull(message = "菜单id不能为空")
    @Size(min = 1, message = "至少选择一项菜单")
    List<String> menuIds;

    @ApiModelProperty("角色id")
    @NotBlank(message = "菜单id不能为空")
    String roleId;

}
