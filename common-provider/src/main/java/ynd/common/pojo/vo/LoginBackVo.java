package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
@ApiModel(value="LoginBack", description="登录实体：Vo")
public class LoginBackVo {

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "密码")
    private String userPassword;

    @ApiModelProperty(value = "电话号码")
    private String phone;

    @ApiModelProperty(value = "登录方式：1->用户名密码登录, 2->邮箱登录, 3->电话号码密码登录 4：电话号码验证码登录, 5->其他登录方式", required = true)
    @NotNull(message = "登录方式不能为空")
    @Range(min = 1, max = 5, message = "取值范围不正确")
    private Integer loginType;

    @ApiModelProperty(value = "验证码登录", required = true)
    @NotBlank(message = "验证码不能为空")
    @Length(min = 4, max = 4, message = "验证码长度不正确")
    private String captcha;

}
