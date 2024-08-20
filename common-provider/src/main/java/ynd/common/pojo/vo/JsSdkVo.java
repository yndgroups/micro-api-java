package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * description 获取微信js-sdk的请求参数
 *
 * @author Yang Daqiong
 * @date 2019-11-20 16:29
 */
@ApiModel("获取JsSdk授权: Vo")
@Accessors(chain = true)
@Data
public class JsSdkVo {

    @ApiModelProperty(value = "随机地址码", required = true)
    @NotBlank(message = "随机地址不能为空")
    private String randomUrl;

    @ApiModelProperty(value = "配置Id", required = true)
    @NotBlank(message = "配置Id不能为空")
    private String confId;

}
