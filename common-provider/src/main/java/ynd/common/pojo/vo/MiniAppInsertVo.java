package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 微应用
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-05-13
 */
@Data
@Accessors(chain = true)
@ApiModel(value="微应用新增", description="微应用")
public class MiniAppInsertVo {

    @ApiModelProperty(value = "微应用发布的服务器地址", required = true)
    @NotBlank(message = "微应用发布的服务器地址不能为空")
    private String url;

    @ApiModelProperty(value = "微应用名称" , required = true)
    @NotBlank(message = "微应用名称不能为空")
    private String title;

    @ApiModelProperty(value = "微应用介绍" , required = true)
    @NotBlank(message = "微应用介绍不能为空")
    private String introduction;

}
