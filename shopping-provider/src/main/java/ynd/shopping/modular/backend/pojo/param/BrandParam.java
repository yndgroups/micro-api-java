package ynd.shopping.modular.backend.pojo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 品牌查询参数
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-08-28
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "品牌查询条件", description = "品牌管理")
public class BrandParam {

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "介绍")
    private String introduction;

    @ApiModelProperty(value = "网址")
    private String url;

}
