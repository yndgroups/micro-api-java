package ynd.shopping.modular.backend.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 购物车项
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-04
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "购物车项新增", description = "购物车项")
public class CartItemInsertDTO {

    @ApiModelProperty(value = "商品数量")
    private Integer quantity;

    @ApiModelProperty(value = "购物车id")
    private Long cartId;

    @ApiModelProperty(value = "库存id")
    private Long skuId;

    @ApiModelProperty(value = "是否已经购买")
    private Integer whetherBuy;

    @ApiModelProperty(value = "版本")
    private String version;

}
