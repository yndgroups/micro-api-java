package ynd.common.pojo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

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
@ApiModel(value="微应用搜素条件", description="微应用")
public class MiniAppParam {

    @ApiModelProperty(value = "小程序发布的服务器地址")
    private String url;

    @ApiModelProperty(value = "小程序名称")
    private String title;

    @ApiModelProperty(value = "小程序介绍")
    private String introduction;

}
