package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

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
@ApiModel(value="角色列表", description="角色表")
public class RoleListVo {

    @ApiModelProperty(value = "角色id")
    private String roleId;

    @ApiModelProperty(value = "应用id")
    private String appId;

    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "角色介绍")
    private String introduce;

    @ApiModelProperty(value = "角色唯一标识: 确定后既不能随意修改")
    private String uniqueIdentification;

    @ApiModelProperty(value = "排序")
    private Integer sortBy;

    @ApiModelProperty(value = "删除状态，1：可用，2：删除")
    private Integer delStatus;

    @ApiModelProperty(value = "创建事件")
    private LocalDate createTime;

}
