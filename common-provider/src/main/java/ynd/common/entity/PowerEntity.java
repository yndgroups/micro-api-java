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
 * 
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_power")
@ApiModel(value="PowerEntity对象", description="")
public class PowerEntity extends BaseEntity {

    @ApiModelProperty(value = "权限id")
    @TableId(value = "power_id", type = IdType.ASSIGN_UUID)
    private Long powerId;

    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty(value = "应用id")
    @TableField("app_id")
    private String appId;

    @ApiModelProperty(value = "角色id")
    @TableField("role_id")
    private String roleId;

    @ApiModelProperty(value = "地区权限")
    @TableField("area")
    private String area;

    @ApiModelProperty(value = "项目id列表集合")
    @TableField("projects")
    private String projects;

    @ApiModelProperty(value = "企业信用代码")
    @TableField("credit_code")
    private String creditCode;

}
