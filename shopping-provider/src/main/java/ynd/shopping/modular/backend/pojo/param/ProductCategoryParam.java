package ynd.shopping.modular.backend.pojo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品分类查询参数
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-22
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "商品分类查询条件", description = "商品分类管理")
public class ProductCategoryParam {

    @ApiModelProperty(value = "分类父级id")
    private String parentId;

}
