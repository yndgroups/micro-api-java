package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
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
@Accessors(chain = true)
@ApiModel(value="用户列表", description="用户管理")
public class UserListVo {

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "电话号码")
    private String phone;

    @ApiModelProperty(value = "微信的openId")
    private String openId;

    @ApiModelProperty(value = "账号状态（1：启用（审核通过），2：禁用，3：待审核）")
    private Integer status;

    @ApiModelProperty(value = "禁用原因")
    private String reasonsProhibition;

    @ApiModelProperty(value = "帐号类型（1：个人账户，2：企业）")
    private Integer accountType;

    @ApiModelProperty(value = "帐号来源某个应用的appId")
    private String appId;

    @ApiModelProperty(value = "帐号来源某个应用的appId")
    private String appName;

    @ApiModelProperty(value = "帐号来源分类（1：后台端：2前端：3: 微信）")
    private Integer regType;

    @ApiModelProperty(value = "删除状态（1：正常，2：删除）")
    private Integer delStatus;

}
