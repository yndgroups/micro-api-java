package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * description 微信登录
 *
 * @author yangdaqiong
 * @date 2021-06-19 09:12:03
 **/
@Data
@ApiModel("微信用户信息同步")
public class WeChatUserInsertVo {

    @ApiModelProperty(value = "配置的id", required = true)
    @NotBlank(message = "配置的id不能为空")
    private  String confId;

    @ApiModelProperty(value = "微信wxCode", required = true)
    @NotBlank(message = "微信code不能为空")
    private  String wxCode;

    @ApiModelProperty(value = "用户id", hidden = true)
    private  Long userId;

    @ApiModelProperty(value = "微信昵称", required = true)
    @NotBlank(message = "微信昵称不能为空")
    private  String nickName;

    @ApiModelProperty("姓名")
    private  String trueName;

    @ApiModelProperty(value = "头像", required = true)
    @NotBlank(message = "微信头像不能为空")
    private  String avatarUrl;

    @ApiModelProperty("性别（1：男， 2：女）")
    private  String gender;

    @ApiModelProperty("用户类型（1：教师，2:学生，3：家长，4：其他社会人员）")
    private  String userType;

    @ApiModelProperty("所在省")
    private  String province;

    @ApiModelProperty("所在市")
    private  String city;

}
