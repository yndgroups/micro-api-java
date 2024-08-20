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
 * 系统用户
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user")
@ApiModel(value="AdminEntity对象", description="系统用户")
public class UserEntity extends BaseEntity {

    @ApiModelProperty(value = "管理员id")
    @TableId(value = "user_id", type = IdType.ASSIGN_UUID)
    private Long userId;

    @ApiModelProperty(value = "用户名")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty(value = "邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "密码")
    @TableField("user_password")
    private String userPassword;

    @ApiModelProperty(value = "电话号码")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "微信的openId")
    @TableField("open_id")
    private String openId;

    @ApiModelProperty(value = "账号状态（1：启用（审核通过），2：禁用，3：待审核）")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "禁用原因")
    @TableField("reasons_prohibition")
    private String reasonsProhibition;

    @ApiModelProperty(value = "帐号类型（1：个人账户，2：企业）")
    @TableField("account_type")
    private Integer accountType;

    @ApiModelProperty(value = "帐号来源某个应用的appId")
    @TableField("source_id")
    private String sourceId;

    @ApiModelProperty(value = "帐号来源分类（1：后台端：2前端：3: 微信）")
    @TableField("reg_type")
    private Integer regType;
}
