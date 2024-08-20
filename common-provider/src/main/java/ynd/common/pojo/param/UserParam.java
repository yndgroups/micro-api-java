package ynd.common.pojo.param;

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
@ApiModel(value="用户搜素条件", description="系统用户")
public class UserParam {

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

}
