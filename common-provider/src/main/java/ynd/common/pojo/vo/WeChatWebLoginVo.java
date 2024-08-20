package ynd.common.pojo.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * description  微信公众号登录
 *
 * @author yangdaqiong
 * @date 2021-08-08 17:25:44
**/
@Data
@ApiModel("微信公众号登录")
public class WeChatWebLoginVo {
    
    @ApiModelProperty(value = "配置的id", required = true)
    @NotBlank(message = "配置的id不能为空")
    private  String confId;

    @ApiModelProperty(value = "微信wxCode", required = true)
    @NotBlank(message = "微信code不能为空")
    private  String wxCode;

}
