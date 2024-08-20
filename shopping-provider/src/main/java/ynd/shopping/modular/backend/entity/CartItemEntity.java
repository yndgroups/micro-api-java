package ynd.shopping.modular.backend.entity;

import ynd.core.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_cart_item")
@ApiModel(value="CartItemEntity对象", description="购物车项")
public class CartItemEntity extends BaseEntity {

    @ApiModelProperty(value = "购物车项id")
    @TableId(value = "ct_id", type = IdType.ASSIGN_UUID)
    private Long ctId;

    @ApiModelProperty(value = "商品数量")
    @TableField("quantity")
    private Integer quantity;

    @ApiModelProperty(value = "购物车id")
    @TableField("cart_id")
    private String cartId;

    @ApiModelProperty(value = "库存id")
    @TableField("sku_id")
    private String skuId;

    @ApiModelProperty(value = "是否已经购买")
    @TableField("whether_buy")
    private Integer whetherBuy;

    @ApiModelProperty(value = "版本")
    @TableField("version")
    private String version;

}
