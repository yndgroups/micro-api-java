package ynd.common.pojo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 *  Role查询参数
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@Accessors(chain = true)
@ApiModel(value="角色搜索条件", description="角色表")
public class RoleParam {

    @ApiModelProperty(value = "应用id", required = true)
    @NotBlank(message = "应用id不能为空")
    private String appId;

}
