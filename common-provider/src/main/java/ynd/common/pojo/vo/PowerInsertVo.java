package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@Accessors(chain = true)
@ApiModel(value="权限新增", description="权限管理")
public class PowerInsertVo {

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "应用id")
    private String appId;

    @ApiModelProperty(value = "角色id")
    private String roleId;

    @ApiModelProperty(value = "地区权限")
    private String area;

    @ApiModelProperty(value = "项目id列表集合")
    private String projects;

    @ApiModelProperty(value = "企业信用代码")
    private String creditCode;

    @ApiModelProperty(value = "删除状态（1：正常，2：删除）")
    private Integer delStatus;

}
