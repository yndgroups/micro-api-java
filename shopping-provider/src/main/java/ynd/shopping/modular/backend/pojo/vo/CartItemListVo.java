package ynd.shopping.modular.backend.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 购物车项列表
 * </p>
 *
 * @author yangdaqiong
 * @date 2021-09-04
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "购物车项列表", description = "购物车项")
public class CartItemListVo {

    @ApiModelProperty(value = "购物车项id")
    private Long id;

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

    @ApiModelProperty(value = "删除状态（false || 0：未删除，true || 1：删除）")
    private Boolean delStatus;

}
