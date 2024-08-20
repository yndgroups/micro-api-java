package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@Accessors(chain = true)
@ApiModel(value="角色新增", description="角色表")
public class RoleInsertVo {

    @ApiModelProperty(value = "应用id", required = true)
    @NotNull(message = "appId不能为空")
    private Long appId;

    @ApiModelProperty(value = "角色名称", required = true)
    @NotNull(message = "角色名称不能为空")
    private String name;

    @ApiModelProperty(value = "角色介绍", required = true)
    @NotNull(message = "角色介绍不能为空")
    private String introduce;

    @ApiModelProperty(value = "角色唯一标识: 确定后既不能随意修改", required = true)
    private String uniqueIdentification;

    @ApiModelProperty(value = "排序")
    private Integer sortBy;

}
