package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@ApiModel("用户关联角色")
@Data
public class UserRelationRoleVo {

    @ApiModelProperty(value = "用户id", required = true)
    @NotBlank(message = "用户id不能为空")
    private String userId;

    @ApiModelProperty(value = "角色ids", required = true)
    @NotNull(message = "角色id不能为空")
    @Size(min = 1, message = "至少一个角色id")
    List<String> roleIds;

    @ApiModelProperty(value = "应用id", required = true)
    @NotBlank(message = "应用id不能为空")
    private String appId;

    @ApiModelProperty(value = "创建者", hidden = true)
    private String createBy;

}
