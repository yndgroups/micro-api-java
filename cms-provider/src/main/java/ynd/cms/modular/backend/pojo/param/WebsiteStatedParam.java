package ynd.cms.modular.backend.pojo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 站点使用协议及声明表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-12-15
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "站点使用协议及声明表查询条件", description = "站点使用协议及声明表管理")
public class WebsiteStatedParam {

    @ApiModelProperty(value = "内容1" , required = true)
    private String content;

}
