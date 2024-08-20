package ynd.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 应用模块
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-10-30
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "应用模块新增", description = "应用模块管理")
public class AppModuleInsertVo {

    @ApiModelProperty(value = "模块id")
    private Long mdId;

    @ApiModelProperty(value = "模块名称")
    private String name;

    @ApiModelProperty(value = "主机地址")
    private String host;

    @ApiModelProperty(value = "路由前缀匹配")
    private String matchPath;

    @ApiModelProperty(value = "js静态资源地址")
    private String jsPath;

    @ApiModelProperty(value = "css静态资源地址")
    private String cssPath;

}
