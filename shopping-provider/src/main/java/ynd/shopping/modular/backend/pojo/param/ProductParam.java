package ynd.shopping.modular.backend.pojo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-11-12
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "商品查询条件", description = "商品管理")
public class ProductParam {

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "副标题")
    private String caption;

    @ApiModelProperty(value = "搜索关键词")
    private String keyword;

}
