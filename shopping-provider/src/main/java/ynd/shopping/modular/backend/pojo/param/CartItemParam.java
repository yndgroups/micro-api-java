package ynd.shopping.modular.backend.pojo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 购物车项查询参数
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-04
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "购物车查询条件", description = "购物车项")
public class CartItemParam {

    @ApiModelProperty(value = "商品数量")
    private Integer quantity;

    @ApiModelProperty(value = "是否已经购买")
    private Integer whetherBuy;

}
