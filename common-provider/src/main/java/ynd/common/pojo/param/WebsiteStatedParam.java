package ynd.common.pojo.param;

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
 * @date 2021-05-13
 */
@Data
@Accessors(chain = true)
@ApiModel(value="站点使用协议及声明搜索条件", description="站点使用协议及声明管理")
public class WebsiteStatedParam {

    @ApiModelProperty(value = "声明标题")
    private String title;

    @ApiModelProperty(value = "声明内容")
    private String content;

}
